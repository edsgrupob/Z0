;Quero desenhar um pralelogramo com bases de 16 pixels e lados de 17 pixels dispostos diagonalmente
;Semelhante a:                   #   #   #   #
;                                    #           #
;                                        #           #   
;                                            #           #   
;                                                #   #   #   #
;cada byte são 16 bits, para desenhar as bases quero usar 16/16=1 write cada
;lembrete: SCREEN começa em 16384 e passo uma linha a cada 512 bits = 32 bytes
;
;
;
;BASES
;
movw $-1, %D
;BASE SUPERIOR:
leaw $16384, %A
movw %D, (%A)
;BASE  INFERIOR:
;Base superior se encontra na linha[0], quero fazer minha inferior na linha[16]
;16 linhas, cada uma 32 bytes significa que devo começar do endereço 16384+16*32=16896
;mais um offset de 16 pixels= 1 byte, temos 16897
leaw $16897, %A
movw %D, (%A)
;
;LINHAS
;
;Quero fazer uma linha por vez, vou precisar de dois bytes para desenhar com um total de 16 bits setados para 1 por linha
;LINHA[1]
leaw $32767, %A
;32767= 01111111 11111111
movw %A, %D
;linha[1]= linha[0]+32 = 16384+32 = 16416
leaw $16416, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[2]
leaw $16383, %A
;16383= 00111111 11111111
movw %A, %D
;linha[2]= linha[1]+32 = 16416+32 = 16448
leaw $16448, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[3]
leaw $8191, %A
;8191= 00011111 11111111
movw %A, %D
;linha[3]= linha[2]+32 = 16448+32 = 16480
leaw $16480, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[4]
leaw $4095, %A
;etc etc
movw %A, %D
;etc etc
leaw $16512, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[5]
leaw $2047, %A
movw %A, %D
leaw $16544, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[6]
leaw $1023, %A
movw %A, %D
leaw $16576, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[7]
leaw $511, %A
movw %A, %D
leaw $16608, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[8]
leaw $255, %A
movw %A, %D
leaw $16640, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[9]
leaw $127, %A
movw %A, %D
leaw $16672, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[10]
leaw $63, %A
movw %A, %D
leaw $16704, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[11]
leaw $31, %A
movw %A, %D
leaw $16736, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[12]
leaw $15, %A
movw %A, %D
leaw $16768, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[13]
leaw $7, %A
movw %A, %D
leaw $16800, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[14]
leaw $3, %A
movw %A, %D
leaw $16832, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;LINHA[15]
leaw $1, %A
movw %A, %D
leaw $16864, %A
movw %D, %A
inc %A
not %D
movw %D, %A
;
;The End
;EOF
