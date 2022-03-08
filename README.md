# Tourism simulator
 an object oriented java program that simulates income/tourists of cities.
## How it works:
 Each city inserted for simulation will have 5 types of attractions initialized which are Food, Nature, Technology, Residence, Historical. Each of these attractions describe a type which can hold a different number of activities, selected  number of activities are given which can be added to the initialized city. a city should also have a price factor, which is used to calculate the percentage of the tourist's spent expenses that is considered income. Each activity is assigned an income value, calculated as "expected expenses", which can represent an average income value from running such activity within a day, which can be determined through statistical means.

 1- Cities:
    - a city can be added to the simulation with a list of selected activities, and a price factor which will yield the income from expected expenses spent by the user.
 2- Tourists:
    - Tourists will randomly decide to visit a city, they are more likely to visit a city with higher attraction factor.
    - The number of tourists represents a pool to enter the simulation, (which can be obtained through statistical means) and is set by default to 2500.
 3- Attractions:
    - There are 5 categories of attractions in the simulation, which are: "Food, Nature, Technology, Residence, Historical"
    - Attractions are meant to organize activities within a city.
 4- activities:
    - Activities are organized by attractions and can be added to a city for simulation.
    - an activity should have a specified income per tourist, which can be obtained through statistical means.
    - an activity should have an attraction points which is a number in Hexadecimal notation.
  5- Attraction factor:
    - Calculated based on attraction points gained from all activities within a city

  ## Features:
    - inserted cities can be edited by price or a customized attraction factor.
    - each simulation run will be counted as a unit of time (day)
    - Save feature which will save all initialized cities into a database file.
  ## To do list:
    - adding a developer mode in the program to ease adding and customizing activities.
    - adding a GUI display for the program.
