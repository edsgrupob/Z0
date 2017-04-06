; Mod.nasm

; Divide o número posicionado na RAM[1] pelo número posicionado no RAM[2] e armazena o resultado na RAM[0].

leaw $1, %A
movw (%A), %D
leaw $2, %A
movw (%A), %A
leaw $0, (%D)
subw
movw (%A), %D
