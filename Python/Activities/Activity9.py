list1 = [10, 21, 4, 45, 66, 93]
list2 = [12, 3, 5, 8, 7, 14]

new_list = []

# Add odd numbers from list1
for num in list1:
    if num % 2 != 0:
        new_list.append(num)

# Add even numbers from list2
for num in list2:
    if num % 2 == 0:
        new_list.append(num)

print("New list:", new_list)
numbers = (10, 23, 45, 50, 67, 90, 3)

for num in numbers:
    if num % 5 == 0:
        print(num)
