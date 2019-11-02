#coding=gbk
'''
Created on 2019年11月2日

@author: Agent Chen
'''
#全局变量定义
from ctypes.wintypes import RGB
SIZE=30                             #方块边长&长度单位，下列所有
WIDTH=10                            #游戏区域横向最大方块数
HEIGHT=20                           #游戏区域竖向最大方块数
SCREEN_WIDTH=(WIDTH+5)*SIZE             #游戏区域宽度
SCREEN_HEIGHT=HEIGHT*SIZE           #游戏区域高度
BORDER=4                           #隔离边框宽度
BGCOLOR=(248,248,255)
BORDER_COLOR=(0,0,0)
LINE_COLOR=(255,255,255)

import pygame
import sys                            #导入系统模块
from pygame.locals import*            #导入所有pygame常量,某些函数需要调用库内常量


def print_text(screen,font,x,y,text,fcolor=(255,255,255)):      #显示文字部分
    imgText = font.render(text,True,fcolor)                     #在新surface上绘制文本
    screen.blit(imgText,(x,y))                                  #显示文本

def main():
    pygame.init()                     #pygame初始化
    screen = pygame.display.set_mode((SCREEN_WIDTH,SCREEN_HEIGHT))
    #set_mode有三个参数可以填(resolution(0.0), flags=0, depth=0)第一个参数指的是分辨率，也就是窗口的大小。第二个参数指的是屏幕附加选项，例如是否全屏等等screen = pygame.display.set_mode((500, 277))#这里示范第一个参数resolution()，也就是分辨率宽500*高277
   
    pygame.display.set_caption("俄罗斯方块")                #设置标题
    font1 = pygame.font.SysFont('SimHei', 26)           #字体格式
    font_pos_x = WIDTH*SIZE+BORDER+5                    #信息显示区域
    font_height = int(font1.size('得分')[1])              #？？？？？
    
    score = 0;                                          #得分初始化
    while True:                                         #退出事件监听
        for event in pygame.event.get():
            if event.type == QUIT:
                sys.exit()
        screen.fill(BGCOLOR)                                #背景色
        #划区域分割线
        pygame.draw.line(screen, BORDER_COLOR, 
                     (WIDTH*SIZE+BORDER//2,0), 
                     (WIDTH*SIZE+BORDER//2,SCREEN_HEIGHT), 
                     BORDER)  
        #划横线
        for y in range(HEIGHT):
            pygame.draw.line(screen,LINE_COLOR,(0,y*SIZE),(WIDTH*SIZE,y*SIZE),1)
            #划竖线
        for x in range(WIDTH):
                pygame.draw.line(screen,LINE_COLOR,(x*SIZE,0),(HEIGHT*SIZE,x*SIZE),1)
        #划分割线，依次为区域，线条颜色，起始点，终结点，宽度         

        #成绩显示区域
        print_text(screen,font1,font_pos_x,10,f'得分:')
        print_text(screen, font1, font_pos_x, 10+font_height+5,f'{score}')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*2,f'级别')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*3,f'{score//10000}')
        print_text(screen, font1, font_pos_x, 10+(font_height+5)*4,f'下一个图形：')
    
        pygame.display.flip()
if __name__ == '__main__':
    main()