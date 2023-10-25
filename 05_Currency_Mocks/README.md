# Currency Converter kata (Mocking)

## Objective

The goal of this kata is to undestand and practice mocking.

## Description

We would like to test a system which convert an amount in a specific currency to another one. The converter method call a service to retrieve the change rate between the two currencies.

Some checks are made during processing

* The amount must be equal or greater than zero.
* Service checks if currencies exist.
* The service could throw other types of exception following the context.
* The returned rate must be equal or greater than zero.
* The result must be between 0 and the maximum value of a double object.

In tests methods the concrete service is not accessible. 
We need to “mock” this one.
