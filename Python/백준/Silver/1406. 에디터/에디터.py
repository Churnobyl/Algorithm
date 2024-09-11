import sys


class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

    def __str__(self) -> str:
        return str(self.data)


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.cursor = None

    def append(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node
            self.cursor = new_node

    def delete(self):
        if self.cursor:
            if self.cursor == self.tail:
                self.tail = self.cursor.prev
                self.tail.next = None
                self.cursor = self.cursor.prev
            elif self.cursor == self.head:
                self.head = self.cursor.next
                self.head.prev = None
                self.cursor = None
            else:
                self.cursor.prev.next = self.cursor.next
                self.cursor.next.prev = self.cursor.prev
                self.cursor = self.cursor.prev

    def move_cursor(self, ins):
        if ins == 'L':
            if self.cursor == self.head:
                self.cursor = None
            elif self.cursor is None:
                pass
            else:
                self.cursor = self.cursor.prev
        elif ins == 'D':
            if self.cursor is None:
                self.cursor = self.head
            elif self.cursor == self.tail:
                pass
            else:
                self.cursor = self.cursor.next

    def insert(self, data):
        new_node = Node(data)

        if self.cursor:
            if self.cursor.next:
                new_node.next = self.cursor.next
                new_node.prev = self.cursor
                self.cursor.next.prev = new_node
                self.cursor.next = new_node
            else:
                self.cursor.next = new_node
                new_node.prev = self.cursor
                self.tail = new_node
            self.cursor = new_node
        else:
            if self.head:
                new_node.next = self.head
                self.head.prev = new_node
                self.head = new_node
                self.cursor = new_node
            else:
                self.head = new_node
                self.tail = new_node
                self.cursor = new_node

    def __str__(self):
        result = []
        iterator = self.head
        while iterator:
            result.append(iterator.data)
            iterator = iterator.next
        return ''.join(result)


string = DoublyLinkedList()

for i in sys.stdin.readline().rstrip():
    string.append(i)

string.cursor = string.tail

M = int(sys.stdin.readline().rstrip())

for _ in range(M):
    ins = sys.stdin.readline().split()
    if ins[0] == 'L':
        string.move_cursor('L')
    elif ins[0] == 'D':
        string.move_cursor('D')
    elif ins[0] == 'B':
        string.delete()
    elif ins[0] == 'P':
        string.insert(ins[1])

print(string)
