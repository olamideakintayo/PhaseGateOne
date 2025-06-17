def adding_students_details():
    while True:
        try:
            students_size = int(input("How many Students do you have? "))
            if students_size <= 0:
                print("Please enter a positive number of students.")
                continue
            break
        except ValueError:
            print("Invalid input! Please enter an integer value.")

    while True:
        try:
            subjects_size = int(input("How many Subjects do they offer? "))
            if subjects_size <= 0:
                print("Please enter a positive number of subjects.")
                continue
            break
        except ValueError:
            print("Invalid input! Please enter an integer value.")

    students_info = [[0] * subjects_size for _ in range(students_size)]
    total_scores = [0] * students_size
    average_scores = [0.0] * students_size

    print("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    print("Saved Successfully")

    for i in range(students_size):
        print(f"\nEntering Scores for Student {i + 1}: ")
        total = 0
        for j in range(subjects_size):
            while True:
                try:
                    score = int(input(f"Enter score for Subject {j + 1}: "))
                    if score < 0 or score > 100:
                        print("Invalid score! Please enter a score between 0 and 100.")
                        continue
                    students_info[i][j] = score
                    total += score
                    break
                except ValueError:
                    print("Invalid input! Please enter a score between 0 and 100.")

        total_scores[i] = total
        average_scores[i] = total / subjects_size

    
    position = [f"{i+1:02}" for i in range(students_size)]

    print("\n" + "=" * 90)
    print(f"{'STUDENT':<10}", end="")
    for j in range(subjects_size):
        print(f"{'SUB' + str(j + 1):>7}", end="")
    print(f"{'TOT':>7}{'AVE':>7}{'POS':>7}")
    print("=" * 90)

    for i in range(students_size):
        print(f"{'Student ' + str(i + 1):<10}", end="")
        for j in range(subjects_size):
            print(f"{students_info[i][j]:7d}", end="")
        print(f"{total_scores[i]:7d}{average_scores[i]:7.2f}{position[i]:>7}")

    print("=" * 90)
    print("=" * 90)

    print("SUBJECT SUMMARY")


if __name__ == "__main__":
    adding_students_details()
