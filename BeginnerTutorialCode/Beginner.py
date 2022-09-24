# print("Hello World!")

# name = input("What is your name? ")
# print("Hello "+name)

# CASTING includes int() str() bool() and float()
# birthYear = input("What is your birth year? ")
# age = 2022 - int(birthYear) 
# print(age)

# type function
# print(type(birthYear))

# stuff you can do with string objects
# course = 'Python'
# print(course.upper())
# print(course.lower())
# print(course.title())
# print(course.find('y'))
# print(course.replace('y','i'))
# print('Py' in course)
# print(len(course))
# print(list(course))

# formatted strings
# first = "John"
# last = "Smith"
# msg = f'{first} [{last}] is a coder'

# multi-line string
# str = '''
# Hello,
# goodbye.
# '''

# arithmatic operators + - * / and // rounds to nearest whole number, also % returns remainder
# ** is power or exponent
# += -= and *= also exist

# operator precedence
# list of priority: parenthesis, exponentiation, multiplication or division, addition or subtraction

# math functions must import module ("import math" at the top)
# print(round(1.1))
# print(abs(-2.9))
# print(ceil(2.9))
# print(floor(2.9))

# comparison operators > < >= <= == !=
# x = 3 > 2
# print(x)

# logical operators "and", "or", "not"
# price = 25
# print(price > 10 and price < 30)
# print(price > 10 or price < 30)
# print(not price<10)

# if statements
# temperature = 15
# if temperature > 30:
#     print("Its a hot day.")
#     print("Drink plenty of water.")
# elif temperature > 20:
#    print("Its a nice day")
# elif temperature > 10:
#    print("Its a bit cold")
# else:
#    print("Its cold")
# print("Done")

# while loops
# i = 1
# while i<=5:
#    print(i)
#    i = i+1
# else:
# while loops can have else ^
# while i<=10:
#    print(i * '*')
#    i = i+1
# break

# Lists
# names = ["John", "Bob", "Shafi", "Sam", "Mary"]
# names[0] = "Jon"
# print(names[-2])
# print(names[0:3])
# print(names[1:])
# print(names[:5])
# print(names[:])

# List Methods
# numbers = [1, 2, 3, 4, 5]
# numbers.append(6)
# numbers.insert(0, -1)
# numbers.remove(3)
# numbers.clear()
# numbers.pop() #removes last element
# numbers.index(5) #checks index of given element
# numbers.count(5) #checks num of occurences of given element
# numbers.sort() #ascending order
# numbers.reverse() #descending order
# numbers2 = numbers.copy() #copies list
# stri = ' '.join(str(numbers)) #turns list to string by combining elements
# print(stri)
# print(1 in numbers) returns boolean value
# print(numbers)
# print(len(numbers)) returns # of elements 


# List iteration
# for item in numbers:
#  print(item)

# i = 0
# while i < len(numbers):
#  print(numbers[i])
#  i = i+1

# tuples (unchangeable lists)
# numbers = (1, 2, 3, 3)
# numbers.count(3)

# for loops 
# for item in 'Python':
#   print(item)
# for item in ['John','Ryan','Shafi']:
#   print(item)

# range function
# numbers = range(5) 0-4
# numbers = range(5, 10) 5-9
# numbers = range(5, 10, 2) 5, 7, 9
# print(numbers)
# for number in numbers:
#  print(number)
# for number in range(5):
#  print(number)

# nested loops
# for x in range(4):
#   for y in range(3):
#     print(f'({x}, {y})')

# 2D Lists / matrix
# matrix = [
#  [1, 2, 3],
#  [4, 5, 6],
#  [7, 8, 9]
# ]
# print(matrix[0])
# print(matrix[0][1])
# for row in matrix:
#  for item in row:
#    print(item)

# unpacking
# coordinates = (1, 2, 3)
# x, y, z = coordinates
# what the above code does is a shorter version of the next 3 lines
# x = coordinates[0]
# y = coordinates[1]
# z = coordinates[2]

# dictionaries, can store key value pairs, no duplicate keys
# customer = {
#  "name": "John Smith",
#  "age": 30,
#  "is_verified": True
# }
# print(customer["name"])
# print(customer.get("name"))
# print(customer.get("birthdate", "May 18, 2004"))
# customer["name"] = "Jack Smith"

# functions
# def greet_user():
#  print('Hi there!')
#  print('Welcome aboard')


# print("Start")
# greet_user()
# print("Finish")

# functions with parameters, uses positional arguments
# def greet_user(fName, lName):
#  print(f'Hi {fName} {lName}!')
#  print('Welcome aboard')


# print("Start")
# greet_user("John", "Smith")
# print("Finish")

# keyword arguments, should always come after positional arguments (when mixing)
# def greet_user(fName, lName):
#  print(f'Hi {fName} {lName}!')
#  print('Welcome aboard')


# print("Start")
# greet_user(lName = "Smith", fName="John")
# print("Finish")

# return statements
# def square(num):
#  return num * num

# result = square(3)
# print(result)
# print(square(4))

# creating a reusable function
# def emoji_converter(message):
#  words = message.split(" ")
#  emojis = {
#      ":)": "😊",
#      ":(": "😢"
#  }
#  output = ""
#  for word in words:
#      output += emojis.get(word, word) + " "
#  return output

# message = input(">")
# print(emoji_converter(message))

# error handling, avoids crashes in program
# try:
#  age = int(input('Age: '))
#  income = 20000
#  risk = income / age
#  print(age)
# except ZeroDivisionError:
#  print('Age cannot be zero')
# except ValueError:
#  print('Invalid value')

# classes
# class Point:
#  def move(self):
#    print("move")
  
#  def draw(self):
#    print("draw")


# point1 = Point()
# point1.x = 10
# point1.y = 20
# print(point1.x)
# point1.draw()

# point2 = Point()
# point2.x = 1
# print(point2.x)

# constructors
# class Point:
#   below constructor block
#  def __init__(self, x, y):
#    self.x = x
#    self.y = y
#   above constructor block
#  def move(self):
#    print("move")
  
#  def draw(self):
#    print("draw")


# point = Point(10, 20)
# point.x = 11
# print(point.x)

# inheritance
# class Mammal:
#  def walk(self):
#    print("Walk")


# class Dog(Mammal):
#  pass # to avoid empty class warning


# class Cat(Mammal):
#  def meow(self):
#    print("Meow")
   

# dog1 = Dog()
# dog1.walk()

# cat1 = Cat()
# cat1.meow()

# modules 
# import Converters
# from Converters import kg_to_lbs

# kg_to_lbs(100)
# or 
# print(Converters.kg_to_lbs(70))

# packages (in pycharm)

#generating random numbers
# import random

# for i in range(3):
#     print(random.random()) #generates a random value between 0 and 1
#     print(random.randint(10, 20)) 

# members = ['John', 'Mary', 'Bob']
# leader = random.choice(members) #generates rand element in list
# print(leader)

#dice exercise
# import random


# class Dice:
#     def roll(self):
#         first = random.randint(1, 6)
#         second = random.randint(1, 6)
#         return first, second


# dice = Dice()
# print(dice.roll())

#working with directories (in pycharm)