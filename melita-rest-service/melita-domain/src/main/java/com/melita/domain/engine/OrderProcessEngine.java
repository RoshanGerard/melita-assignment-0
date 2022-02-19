package com.melita.domain.engine;

import com.melita.domain.dto.OrderRequestDto;
import com.melita.domain.dto.OrderResponseDto;
import com.melita.domain.exception.ValidationException;
import com.melita.domain.model.InstallationAddressModel;
import com.melita.domain.model.InstallationTimeScheduleModel;
import com.melita.domain.model.PersonalDetailsModel;
import com.melita.domain.model.ProductServiceModel;
import com.melita.domain.type.Product;
import com.melita.domain.type.ProductPackage;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Order processing engine.
 *
 * @author Roshan Bolonna
 */
public class OrderProcessEngine {

    private final EmailValidator emailValidator = EmailValidator.getInstance();

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        final ArrayList<String> messages = validateOrderRequest(orderRequestDto);

        if (messages.size() > 0) {
            throw new ValidationException(messages);
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(UUID.randomUUID().toString());
        orderResponseDto.setMessage("Order placed successfully.");

        return orderResponseDto;
    }

    private ArrayList<String> validateOrderRequest(OrderRequestDto orderRequestDto) {
        final ArrayList<String> messages = new ArrayList<>();

        if (orderRequestDto == null) {
            messages.add("No order details found.");
        } else {
            final ArrayList<String> personalDetailsResult = validatePersonalDetails(orderRequestDto.getPersonalDetails());
            final ArrayList<String> installDetailsResult = validateInstallationAddress(orderRequestDto.getInstallationAddress());
            final ArrayList<String> installTimeScheduleResult =
                    validateInstallationTimeSchedule(orderRequestDto.getInstallationTimeSchedule());
            final ArrayList<String> productServiceResult = validateProductServices(orderRequestDto.getProductServiceModel());

            messages.addAll(personalDetailsResult);
            messages.addAll(installDetailsResult);
            messages.addAll(installTimeScheduleResult);
            messages.addAll(productServiceResult);
        }

        return messages;
    }

    private ArrayList<String> validateProductServices(ProductServiceModel productService) {
        final ArrayList<String> messages = new ArrayList<>();

        if (productService == null) {
            messages.add("Product services not specified.");
        } else {
            final Product selectedProduct = productService.getProduct();
            final ProductPackage selectedPackage = productService.getProductPackage();

            if (selectedPackage == null) {
                messages.add("Product package not specified.");
            } else {
                // Validate specified product package.
                switch (selectedPackage) {
                    case INTERNET_1GBPS:
                    case INTERNET_250MBPS:
                    case MOBILE_POSTPAID:
                    case MOBILE_PREPAID:
                    case TELEPHONY_FREE_NET_CALLS:
                    case TELEPHONY_UNLIMITED_CALLS:
                    case TV_90_CHANNELS:
                    case TV_140_CHANNELS:
                        break;
                    default:
                        messages.add("Invalid or unknown product package type, specified product-package doesn't exists.");
                        break;
                }
            }

            if (selectedProduct == null) {
                messages.add("Product not specified.");
            } else {
                // Validate specified product type.
                switch (selectedProduct) {
                    case INTERNET:
                        if (selectedPackage != ProductPackage.INTERNET_1GBPS
                                || selectedPackage != ProductPackage.INTERNET_250MBPS) {
                            messages.add("Selected package not valid for: " + Product.INTERNET + " product.");
                        }

                        break;
                    case MOBILE:
                        if (selectedPackage != ProductPackage.MOBILE_PREPAID
                                || selectedPackage != ProductPackage.MOBILE_POSTPAID) {
                            messages.add("Selected package not valid for: " + Product.MOBILE + " product.");
                        }

                        break;
                    case TELEPHONY:
                        if (selectedPackage != ProductPackage.TELEPHONY_FREE_NET_CALLS
                                || selectedPackage != ProductPackage.TELEPHONY_UNLIMITED_CALLS) {
                            messages.add("Selected package not valid for: " + Product.TELEPHONY + " product.");
                        }

                        break;
                    case TV:
                        if (selectedPackage != ProductPackage.TV_90_CHANNELS
                                || selectedPackage != ProductPackage.TV_140_CHANNELS) {
                            messages.add("Selected package not valid for: " + Product.TV + " product.");
                        }

                        break;
                    default:
                        messages.add("Invalid or unknown product type, specified product doesn't exists.");
                        break;
                }
            }
        }

        return messages;
    }

    private ArrayList<String> validateInstallationTimeSchedule(InstallationTimeScheduleModel installationTimeSchedule) {
        final ArrayList<String> messages = new ArrayList<>();

        if (installationTimeSchedule == null) {
            messages.add("Installation time schedule details not specified.");
        } else {
            if (StringUtils.isEmpty(installationTimeSchedule.getInstallTime())) {
                messages.add("Specified time invalid or not specified.");
            }

            if (StringUtils.isEmpty(installationTimeSchedule.getInstallDate())) {
                messages.add("Specified date invalid or not specified.");
            }
        }

        return messages;
    }

    private ArrayList<String> validateInstallationAddress(InstallationAddressModel installationAddress) {
        final ArrayList<String> messages = new ArrayList<>();

        if (installationAddress == null) {
            messages.add("Installation address not specified.");
        } else {
            if (StringUtils.isEmpty(installationAddress.getCountry())) {
                messages.add("Country not specified.");
            }

            if (StringUtils.isEmpty(installationAddress.getState())) {
                messages.add("State / Province not specified.");
            }

            if (StringUtils.isEmpty(installationAddress.getStreet())) {
                messages.add("Street details not specified.");
            }
        }

        return messages;
    }

    private ArrayList<String> validatePersonalDetails(PersonalDetailsModel personalDetails) {
        final ArrayList<String> messages = new ArrayList<>();

        if (personalDetails == null) {
            messages.add("Personal details not specified.");
        } else {
            if (StringUtils.isEmpty(personalDetails.getFirstName())) {
                messages.add("First name not specified.");
            }

            if (StringUtils.isEmpty(personalDetails.getLastName())) {
                messages.add("Last name not specified.");
            }

            if (StringUtils.isEmpty(personalDetails.getEmail())) {
                messages.add("Email not specified.");
            } else if (!emailValidator.isValid(personalDetails.getEmail())) {
                messages.add("Specified email not valid.");
            }

            if (StringUtils.isEmpty(personalDetails.getMobileNo())) {
                messages.add("Mobile number not specified.");
            }

            if (StringUtils.isEmpty(personalDetails.getNic())) {
                messages.add("Identity card number not specified.");
            }
        }

        return messages;
    }
}
