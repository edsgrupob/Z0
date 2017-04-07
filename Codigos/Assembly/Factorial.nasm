; Factorial.nasm
; Calcula o fatorial do número em R0 e armazena o valor em R1.

;Pega o número inicial
leaw $0, %A
movw (%A), %D
;R1 inicializado
leaw $1, %A
movw %D, (%A)
dec %D
dec %D
;R2 inicializado
leaw $2, %A
movw %D, (%A)


;Tratar o caso em que R1= 0 ou 1
TRATARESPECIAL:
;se for zero, somar 1
leaw $1, %A
movw (%A), %D
leaw $CASOZERO, %A
je
nop

;se for um, escapar
leaw $1, %A
movw (%A), %D
dec %D
leaw $ESCAPE, %A
je
nop


GREATERLOOP:
;carregar R2 em D
;conferir se ele é não zero
leaw $2, %A
movw (%A), %D
;escapar se R2 for zero
leaw $ESCAPE, %A
je
nop

;--conteúdo de GREATERLOOP
;jogar R2 em R3
leaw $2, %A
movw (%A), %D
leaw $3, %A
movw %D, (%A)

;jogar R1 em R4
leaw $1, %A
movw (%A), %D
leaw $4, %A
movw %D, (%A)

leaw $2, %A
dec (%A)
;--fim de GREATERLOOP

LESSERLOOP:
;carregar R3 em D
;conferir se ele é não zero
;se R3 for zero voltar pra GREATERLOOP
leaw $3, %A
movw (%A), %D
leaw $GREATERLOOP, %A
je
nop

;---conteúdo de LESSERLOOP
;somar R4 em R1
leaw $4, %A
movw (%A), %D
leaw $1, %A
add %D, (%A), (%A)

;decrementar R3
leaw $3, %A
dec (%A)
;---fim de LESSERLOOP
;repetir LESSERLOOP
leaw $LESSERLOOP, %A
jmp
nop

CASOZERO:
;---R1 é zero, devo incrementar ele
leaw $1, %A
inc (%A)
leaw $TRATARESPECIAL, %A
jmp
nop

ESCAPE:
nop
