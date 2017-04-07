; Hexagon.nasm

; Desenha um hexagon na tela.

;linha1
lea $16400, %A
movw $-1, (%A)
movw %A, %D
movw $0, %A
movw %D, (%A)
incw (%A)

;linha2
leaw $16431, %A
movw $-1, (%A)
movw %A, %D
movw $0, %A
movw %D, (%A)
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

;linha3
leaw $16462, %A
movw $-1, (%A)
movw %A, %D
movw $0, %A
movw %D, (%A)
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

;linha4
leaw $16495, %A
movw $-1, (%A)
movw %A, %D
movw $0, %A
movw %D, (%A)
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

leaw $0, %A
movw (%A), %D
movw %D, %A
movw $-1, (%A)
leaw $0, %A
incw (%A)

;linha5
leaw $16528, %A
movw $-1, (%A)
movw %A, %D
movw $0, %A
movw %D, (%A)
incw (%A)