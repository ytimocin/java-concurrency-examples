# Java volatile keyword learnings

## Contribute

* Link to my document on volatile: https://docs.google.com/document/d/1Yq5MfrIL_U-hklwbteG8t0EV-CdJ8AHoP0ALQBKlViE/edit?usp=sharing


* Please feel free to leave comments.

## Important concepts

* **Instruction Reordering**: The Java VM and the CPU are allowed to reorder instructions in the program for performance reasons making sure that the semantic meaning stays the same.


* **Visibility Guarantee**: The volatile keyword guarantees visibility of changes to variables across threads. It makes sure that the writes and reads happen at the main memory level instead of CPU (or local) cache leve.


* **Happens-Before Guarantee**

## My Own Understanding

If a variable is declared as volatile, and gets a modification (meaning that there is a write to that variable), that write point is like a checkpoint for all the variables in that context. We can also think of it as like the **flush** feature of a cache. At that point all values of all variables get written to the main memory.


(More to come)

