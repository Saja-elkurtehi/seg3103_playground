SEG3103 Lab 08: Mutation Testing
Saja Elkurtehi 
300288667

Screenshots

Starting the PITest Plugin
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab08/assets/1.png 

HTML Report Screenshots
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab08/assets/2.png
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab08/assets/3.png


Mutation Explanations

The mutations detailed in the report involve changes such as swapping arithmetic operators, like replacing addition with subtraction or multiplication with division. These alterations test whether the existing test cases can detect such changes.

For instance, here are some active mutators from the PITest documentation:

INCREMENTS_MUTATOR: This mutator alters increments and decrements of local variables by replacing increments with decrements and vice versa.
VOID_METHOD_CALL_MUTATOR: This one removes method calls to void methods.
RETURN_VALS_MUTATOR: This has been replaced by new return mutators that cover empty, false, true, null, and primitive returns.
MATH_MUTATOR: It changes binary arithmetic operations to different operations for both integers and floating-point numbers.
NEGATE_CONDITIONALS_MUTATOR: It mutates all conditionals by negating them.
INVERT_NEGS_MUTATOR: This mutator inverts the negation of integer and floating-point variables.
CONDITIONALS_BOUNDARY_MUTATOR: It replaces relational operators like <, <=, >, >= with their boundary counterparts.
Definition of a Killed Mutant
A mutant is considered killed when the test suite detects the change introduced by the mutation. This typically results in the test either producing a different output or encountering an error, indicating that the test case is successfully identifying that type of issue
