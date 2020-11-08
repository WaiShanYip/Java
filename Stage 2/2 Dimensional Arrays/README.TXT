PROJECT TITLE: Lithium Simulator
PURPOSE OF PROJECT: Stage 2 of University. Algorithms, Correctness and Efficiency ~ Assignment 1
VERSION or DATE: 05/10/2019
AUTHORS: Wai Shan (Karen) Yip
EXPLANATION: 
This assignment focuses on 2 dimensional arrays. 
The Lithium Simulator evaluates lithium samples as the quality of lithium can vary greatly. 
It can be used for grading, sorting and pricing lithium.

The class GenerateLithium generates the tray of lithium using a 2 dimensional array which is printed out using the generateSample() method.

The class LithiumGrading uses the tray from the GenerateLithium class and grades it.
Lithium above the grade of 25 is considered a high grade and is added to the highGrade arraylist.
Lithium below the grade of 25 is considered a low grade and is added to the lowGrade arraylist.
The sortingLithium method uses a bubble sort to sort the arrays in ascending order.

The class LithiumPricing uses hashmaps to set the price of lithium.
Lithium graded between 1-9 is priced at £300.
Lithium graded between 10-19 is priced at £600.
Lithium graded between 20-29 is priced at £900.
Lithium graded above 30 is priced at £1250.
The setPrice() method sets the price, and printPrice() prints this information.

The class BuyLithium offers a buyer the chance to enter a price which will display an offer at the given price.
The method findBestPrice() shows all the lithium grades with their prices and displays the amount of choices available.
The method findHighQuality() shows the lithium grades with their prices based on the quality chosen.
