# Assignment
Develop an authenticated Order Taking API stack that is exposed to 3rd party endpoints (example an
ERP system) selling products on behalf of Melita.

An order specifies the customer details (including personal details, installation address, preferred
installation date + time slot details), the required products (e.g. Internet, TV, Telephony, Mobile) and
the required package per product (e.g. Internet 250Mbps or 1Gbps, TV with 90 Channels or 140

Channels, Telephony with Free On net Calls or Unlimited Calls, Mobile Prepaid or Mobile Post-
paid). The Order Taking API must validate these details and accept the order. On accepting the

order it must publish a messaging event to a RabbitMQ topic for Melita's Ordering Fulfilment system
and Care systems to pick it up.

We expect the following deliverables:-
1) An authenticated public REST based Order Taking API stack.
2) Micro services to be implemented using Spring Boot
3) Publish events to a RabbitMQ
4) Code needs to be version controlled in a Git Repo
5) Expect very good code design and robust error handling, design and integration patterns
employed
