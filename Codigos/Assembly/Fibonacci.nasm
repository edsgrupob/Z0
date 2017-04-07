;Fibonacci
;0, 1, 1, 2, 3, 5, 8, ...

; Setar 0 na posição 1
leaw $0, %A
movw %A, %D
leaw $1, %A
movw %D, (%A)

; Setar 1 na posição 2
leaw $1, %A
movw %A, %D
leaw $2, %A
movw %D, (%A)

; Setar contadores de posição do elemento
leaw $1, %A
movw %A, %D
leaw $1000, %A
movw %D, (%A)
leaw $2, %A
movw %A, %D
leaw $1001, %A
movw %D, (%A)


; Repetir

SEQUENCIA:
leaw $1000, %A
movw (%A), %A 
movw (%A), %D
leaw $1001, %A
movw (%A), %A
addw (%A), %D, %D ;somando 
leaw $1000, %A
incw (%A) ;soma, fica 2 em 1000
leaw $1001, %A
incw (%A) ;soma, fica 3 em 1001
;movw %D, (%A) ;move soma para posição 3 *********
leaw $1001, %A
movw (%A),%A
movw %D,(%A)
leaw $0, %A
decw (%A)
movw (%A), %D
leaw $0, %A
movw %D, %A

leaw %SEQUENCIA, %A
jne
