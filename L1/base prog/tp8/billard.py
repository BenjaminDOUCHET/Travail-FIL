from turtle import *
from math import tan
from math import pi


def anglerad(x):
    """
    nous renvoi l'angle en rad depuis des degrès
    x ( int ou float ) l'angle en degrès
    """
    return (x*pi/180)


def billard(largeur , longueur , xinit , yinit , deg , bande ):
    """
    fonction nous donnant la trajectoire de la boule de billard
    largeur ( int ou float) la largeur de la table
    longueur ( int ou float) la longueur de la table
    xinit ( int ou float ) la position initiale de la boule en X
    yinit ( int ou float ) la position initiale de la boule en Y
    deg ( int ou float ) angle entre 0 et 360 degrès du premier tir
    bande (int) strist pos. le nombre de bandes à effectuer
    C.U les coordonnées initiales doivent être dans les dimensions de la table
    """
    assert deg <=360 and deg >=0
    clearscreen()
    home()
    penup()
    goto(-(largeur/2) , (-longueur/2))
    pendown()
    speed(0)
    ydest=0
    xdest=0
    angle=0
    rad=0
    l=largeur/2
    L=longueur/2
    
    pensize(3)
    fillcolor('green')
    begin_fill()
    for c in range(2) :

        forward(largeur)
        left(90)
        forward(longueur)
        left(90)
    end_fill()
    
    penup()
    goto(xinit,yinit)
    left(deg)
    pendown()
    pensize(1)
    
    for i in range(bande) :
        angle= heading()
        
        if angle > 0 and angle < 90 :
            rad=anglerad(angle)
            ydest = ycor()+((l)-xcor())*tan(rad)
            if ydest <= L :
                goto(l , ydest)
                left(180-(2*angle))
            else :
                xdest = xcor() + (L-ycor())/tan(rad)
                goto(xdest,L)
                right(180-(2*(90-angle)))
        
        if angle > 90 and angle < 180 :
            angle = 180-angle
            rad=anglerad(angle)
            ydest=ycor()+(xcor()+l)*tan(rad)
            
            if ydest <= L :
                goto(-l , ydest)
                right(180-(2*angle))
            else :
                xdest= xcor()-(L-ycor())/(tan(rad))
                goto(xdest,L)
                left(180-(2*(90-angle)))
                
        if angle > 180 and angle < 270 :
            angle= angle -180
            rad=anglerad(angle)
            ydest = ycor()-((xcor()+l)*tan(rad))
            if ydest >= -L :
                goto(-l , ydest)
                left(180-(2*angle))
            else :
                xdest=xcor()-((ycor()+L)/tan(rad))
                goto(xdest , -L)
                right(180-(2*(90-angle)))
        
        if angle > 270 and angle < 360 :
            angle = 360 - angle
            rad=anglerad(angle)
            ydest = ycor()-(l-xcor())*tan(rad)
            if ydest >= -L :
                goto(l , ydest)
                right(180-(2*angle))
            else :
                xdest = xcor()+((ycor()+L)/tan(rad))
                goto(xdest,-L)
                left(180-(2*(90-angle)))
            
        if angle == 90 :
            xdest = xcor()
            goto(xdest,L)
            left(180)
        if angle == 180 :
            ydest = ycor()
            goto(-l , ydest)
            left(180)
        if angle == 270 :
            xdest = xcor()
            goto(xdest , -L)
            left(180)
        if angle == 360 or angle == 0 :
            ydest = ycor()
            goto(l , ydest)
            
            
        
                
                