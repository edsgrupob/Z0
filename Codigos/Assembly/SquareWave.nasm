; SquareWave.nasm

; Desenha um onda quadrada na tela.

;Desenhando as linhas superiores
leaw $16384, %A
movw $-1, (%A)

leaw $16386, %A
movw $-1, (%A)

leaw $16388, %A
movw $-1, (%A)
