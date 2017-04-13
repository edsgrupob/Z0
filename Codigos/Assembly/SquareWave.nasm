; SquareWave.nasm

; Desenha um onda quadrada na tela.

;Atribuindo valor '32' pro %D
leaw $32, %A
movw %A, %D

;Desenhando as linhas superiores
leaw $16384, %A
movw $-1, (%A)

leaw $16386, %A
movw $-1, (%A)

;Desenhando as linhas inferiores
leaw $16897,%A
movw $-1 (%A);

leaw $16899,%A
movw $-1 (%A);

;Desenhando subidas e descidas
;INICIANDO PRIMEIRA LINHA VERTICAL
leaw $16385, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)


;INICIANDO SEGUNDA LINHA VERTICAL
leaw $16418, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)

;INICIANDO TERCEIRA LINHA VERTICAL
leaw $16387, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
add %D, %A, %A
movw $1, (%A)
