;Quero desenhar um pralelogramo com bases de 16 pixels e lados de 16 pixels dispostos diagonalmente
;Semelhante a:                   #   #   #   #  #
;                                    #       #
;                                        #
;                                    #       # 
;                                #   #   #   #  #
;cada byte são 16 bits, para desenhar as bases quero usar 16/16=1 write cada
;lembrete: SCREEN começa em 16384 e passo uma linha a cada 512 bits = 32 bytes
;
;
;
;LINHA[0]
;BASE SUPERIOR:
movw $-1, %D
leaw $16384, %A
movw %D, (%A)
;
;Linha[1]
;Para cada linha vou querer somar 32 ao endereço, que é o numero de bytes em uma linha
;de forma que, linha[n+1]=linha[n]+32
leaw $32766, %A
;32766= 01111111 11111110
movw %A, %D
leaw $16416, %A
movw %D, (%A)
;
;Linha[2]
leaw $16380, %A
;16380= 00111111 11111100
movw %A, %D
leaw $16448, %A
movw %D, (%A)
;
;Linha[3]
leaw $8184, %A
;8184= 00011111 11111000
movw %A, %D
leaw $16480, %A
movw %D, (%A)
;
;Linha[4]
leaw $4080, %A
;etc etc
movw %A, %D
leaw $16512, %A
movw %D, (%A)
;
;Linha[5]
leaw $2016, %A
movw %A, %D
leaw $16544, %A
movw %D, (%A)
;
;Linha[6]
leaw $960, %A
movw %A, %D
leaw $16576, %A
movw %D, (%A)
;
;Linha[7]
leaw $384, %A
;384= 0000000110000000
;A partir deste valor começo a repetir os passados do menor pro maior
movw %A, %D
leaw $16608, %A
movw %D, (%A)
;
;Linha[8]
leaw $960, %A
movw %A, %D
leaw $16640, %A
movw %D, (%A)
;
;Linha[9]
leaw $2016, %A
movw %A, %D
leaw $16672, %A
movw %D, (%A)
;
;Linha[10]
leaw $4080, %A
;etc etc
movw %A, %D
leaw $16704, %A
movw %D, (%A)
;
;Linha[11]
leaw $8184, %A
movw %A, %D
leaw $16736, %A
movw %D, (%A)
;
;Linha[12]
leaw $16380, %A
movw %A, %D
leaw $16768, %A
movw %D, (%A)
;
;Linha[13]
leaw $32766, %A
movw %A, %D
leaw $16800, %A
movw %D, (%A)
;
;LINHA[14]
;BASE INFERIOR:
movw $-1, %D
leaw $16832, %A
movw %D, (%A)
;
;The End
;EOF
