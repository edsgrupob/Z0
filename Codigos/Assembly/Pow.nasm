; Pow.nasm

; Eleva ao quadrado o valor da RAM[1] e armazena o resultado na RAM[0].
; Só funciona com números positivos

leaw $1, %A
movw (%A), %D
leaw $0, %A
movw %D, (%A) 
leaw $2, %A
movw %D, (%A)
decw (%A)

MULTIPLIC:
leaw $0, %A
movw (%A), %D
leaw $1, %A
addW (%A), %D, %D
leaw $2, %A
decw (%A)

leaw $0, %A
movw %D, (%A)

leaw $2, %A
movw (%A), %D
leaw %MULTIPLIC, %A
jne
END:
leaw $END, %A 
jmp