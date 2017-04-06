leaw $2, %A
movw %A,%D
leaw $1000, %A
movw %D, (%A)
leaw S1, %A
movw %A,%D
leaw $1001, %A
movw %D, (%A)
leaw $0, %A
movw $0,(%A)
leaw $1, $A
movw $1, (%A)
LOOP:
leaw $1001, %A
movw (%A), %A
movw (%A), %D
leaw $1000, %A
movw (%A), %A
movw %D, (%A)
leaw $1000, %A
addw (%A), $1, (%A)
leaw $1001, %A
movw (%A), %A
movw (%A), %D
addw %A, $1, %A
addw (%A), %D, %D
leaw $1000, %A
movw (%A), %A
movw %D, (%A)
leaw $1000, %A
addw (%A), $1, (%A)
leaw $1001, %A
addw (%A), $1, (%A)
leaw $LOOP,%A
jmp