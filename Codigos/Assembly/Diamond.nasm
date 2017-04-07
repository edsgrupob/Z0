; Diamond.nasm

; Desenha um Losango na tela.

leaw $16896,%A
movw %A,%D

leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw $1,(%A)

LOOP2:

leaw $1,%A
movw (%A),%D

leaw $0,%A

movw (%A),%A

movw %D,(%A)
movw %A, %D
leaw $32, %A

subw %D,%A,%D
leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw (%A), %D

addw (%A), %D, %D
movw %D, (%A) 

leaw $0, %A
movw (%A), %D
leaw $16384 , %A
subw %D, %A, %D

leaw $LOOP2,%A
jge
;------------------------------------------
leaw $16385,%A
movw %A,%D

leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw $1,(%A)

LOOP:

leaw $1,%A
movw (%A),%D

leaw $0,%A

movw (%A),%A

movw %D,(%A)
movw %A, %D
leaw $32, %A

addw %A,%D,%D
leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw (%A), %D

addw (%A), %D, %D
movw %D, (%A) 

leaw $0, %A
movw (%A), %D
leaw $16897 , %A
subw %D, %A, %D

leaw $LOOP,%A
jle

;-----------------------------------------------
leaw $17409,%A
movw %A,%D

leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw $1,(%A)

LOOP3:

leaw $1,%A
movw (%A),%D

leaw $0,%A

movw (%A),%A

movw %D,(%A)
movw %A, %D
leaw $32, %A

subw %D,%A,%D
leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw (%A), %D

addw (%A), %D, %D
movw %D, (%A) 

leaw $0, %A
movw (%A), %D
leaw $16897 , %A
subw %D, %A, %D

leaw $LOOP3,%A
jge
;------------------------------------------------------
leaw $16896,%A
movw %A,%D

leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw $1,(%A)

LOOP4:

leaw $1,%A
movw (%A),%D

leaw $0,%A

movw (%A),%A

movw %D,(%A)
movw %A, %D
leaw $32, %A

addw %A,%D,%D
leaw $0,%A
movw %D,(%A)

leaw $1, %A
movw (%A), %D

addw (%A), %D, %D
movw %D, (%A) 

leaw $0, %A
movw (%A), %D
leaw $17408 , %A
subw %D, %A, %D

leaw $LOOP4,%A
jle


END:
leaw $END,%A
jmp
