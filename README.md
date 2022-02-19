# melita-assignment
Melita screening interview 2022-FEB-18

<h3>Specification</h3>
Java 8<br/>
SpringBoot 2.4<br/>
Gradle 6.3<br/>
RabbitMQ 3.9.13<br/>
IntelliJ

<h3>Services</h3>

<h4>Melita REST Service</h4>
<p>
  The rest api service for placing orders and exposing to third-party end-points.
</p>

<h4>Melita Fulfillment Service</h4>
<p>
  The fullfilment service will receive notifications for successfully placed orders.
</p>

<h3>How to Run</h3>
<p>
  First open both projects using IntelliJ, then launch:<br/>
   - 1. melita-rest-service</br>
   - 2. melita-fulfillment-service
</p>

<h3>Examples</h3>
<p>Following examples will demonstrate placing orders, .etc</p>

<h4>Place an Order</h4>
<h5>POST http://localhost:5006/api/order/place</h5>

<h6>Request body</h6>
<pre>
{
    "personalDetails": {
        "firstName": "Roshan",
        "lastName": "Bolonna",
        "nic": "123",
        "email": "roshan@acme.com",
        "mobileNo": "+94 6622 454"
    },
    "installationAddress": {
        "street": "Station road",
        "country": "Sri Lanka",
        "state": "Western"
    },
    "installationTimeSchedule": {
        "installDate": "2022-02-21",
        "installTime": "11:30:00"
    },
    "productServiceModel": {
        "product": "INTERNET",
        "productPackage": "TV_90_CHANNELS"
    }
}
</pre>

<h6>Supported Products</h6>
<ul>
  <li>INTERNET</li>
  <li>TV</li>
  <li>TELEPHONY</li>
  <li>MOBILE</li>
</ul>

<h6>Supported Packages</h6>
<ul>
  <li>INTERNET_250MBPS</li>
  <li>INTERNET_1GBPS</li>
  <li>TV_90_CHANNELS</li>
  <li>TV_140_CHANNELS</li>
  <li>TELEPHONY_FREE_NET_CALLS</li>
  <li>TELEPHONY_UNLIMITED_CALLS</li>
  <li>MOBILE_PREPAID</li>
  <li>MOBILE_POSTPAID</li>
</ul>
