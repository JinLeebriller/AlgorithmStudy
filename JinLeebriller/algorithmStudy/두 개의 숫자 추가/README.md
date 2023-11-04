# 두 개의 숫자 추가

### 문제 설명

두 개의 음이 아닌 정수를 나타내는 비어 있지 않은 연결된 목록이 두 개 주어집니다. 숫자는 역순으로 저장되고 각 노드는 한 개의 숫자를 포함합니다. 두 숫자를 더하고 합을 연결된 목록으로 반환합니다.

두 숫자에는 0이라는 숫자 자체를 제외하고 선행 0이 포함되어 있지 않다고 가정할 수 있습니다.

### 영어 원문
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

<hr>

<h4>예제</h4>

예제 입력 #1</br>
l1 = [2,4,3], l2 = [5,6,4] </br>
예제 출력 #1</br>
[7,0,8] </br>
설명 : 342 + 465 = 807 </br>

예제 입력 #2</br>
l1 = [0], l2 = [0] </br>
예제 출력 #2</br>
[0] </br>

예제 입력 #3</br>
l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] </br>
예제 출력 #3</br>
[8,9,9,9,0,0,0,1] </br>

<hr>

<h4>제약 사항</h4>

링크된 각 목록의 노드 수는 [1, 100] 범위입니다.

0 <= Node.val <= 9

이 목록은 선행 0이 없는 숫자를 나타냅니다.

<h4>영어 원문</h4>
The number of nodes in each linked list is in the range [1, 100].</br></br>

0 <= Node.val <= 9

It is guaranteed that the list represents a number that does not have leading zeros.
