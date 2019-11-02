#coding=gbk
'''
Created on 2019��11��2��

@author: Agent Chen
'''
#ȫ�ֱ�������
from ctypes.wintypes import RGB
SIZE=30                             #����߳�&���ȵ�λ����������
WIDTH=10                            #��Ϸ���������󷽿���
HEIGHT=20                           #��Ϸ����������󷽿���
SCREEN_WIDTH=(WIDTH+5)*SIZE             #��Ϸ������
SCREEN_HEIGHT=HEIGHT*SIZE           #��Ϸ����߶�
BORDER=4                           #����߿���
BGCOLOR=(248,248,255)
BORDER_COLOR=(0,0,0)
LINE_COLOR=(255,255,255)

import pygame
import sys                            #����ϵͳģ��
from pygame.locals import*            #��������pygame����,ĳЩ������Ҫ���ÿ��ڳ���


def print_text(screen,font,x,y,text,fcolor=(255,255,255)):      #��ʾ���ֲ���
    imgText = font.render(text,True,fcolor)                     #����surface�ϻ����ı�
    screen.blit(imgText,(x,y))                                  #��ʾ�ı�

def main():
    pygame.init()                     #pygame��ʼ��
    screen = pygame.display.set_mode((SCREEN_WIDTH,SCREEN_HEIGHT))
    #set_mode����������������(resolution(0.0), flags=0, depth=0)��һ������ָ���Ƿֱ��ʣ�Ҳ���Ǵ��ڵĴ�С���ڶ�������ָ������Ļ����ѡ������Ƿ�ȫ���ȵ�screen = pygame.display.set_mode((500, 277))#����ʾ����һ������resolution()��Ҳ���Ƿֱ��ʿ�500*��277
   
    pygame.display.set_caption("����˹����")                #���ñ���
    font1 = pygame.font.SysFont('SimHei', 26)           #�����ʽ
    font_pos_x = WIDTH*SIZE+BORDER+5                    #��Ϣ��ʾ����
    font_height = int(font1.size('�÷�')[1])              #����������
    
    score = 0;                                          #�÷ֳ�ʼ��
    while True:                                         #�˳��¼�����
        for event in pygame.event.get():
            if event.type == QUIT:
                sys.exit()
        screen.fill(BGCOLOR)                                #����ɫ
        #������ָ���
        pygame.draw.line(screen, BORDER_COLOR, 
                     (WIDTH*SIZE+BORDER//2,0), 
                     (WIDTH*SIZE+BORDER//2,SCREEN_HEIGHT), 
                     BORDER)  
        #������
        for y in range(HEIGHT):
            pygame.draw.line(screen,LINE_COLOR,(0,y*SIZE),(WIDTH*SIZE,y*SIZE),1)
            #������
        for x in range(WIDTH):
                pygame.draw.line(screen,LINE_COLOR,(x*SIZE,0),(HEIGHT*SIZE,x*SIZE),1)
        #���ָ��ߣ�����Ϊ����������ɫ����ʼ�㣬�ս�㣬���         

        #�ɼ���ʾ����
        print_text(screen,font1,font_pos_x,10,f'�÷�:')
        print_text(screen, font1, font_pos_x, 10+font_height+5,f'{score}')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*2,f'����')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*3,f'{score//10000}')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*4,f'��һ��ͼ�Σ�')
    
        pygame.display.flip()
if __name__ == '__main__':
    main()