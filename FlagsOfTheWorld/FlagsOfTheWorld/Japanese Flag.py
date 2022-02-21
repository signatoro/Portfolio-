import turtle








def draw_circle(height, length, pos, color):
    height = height/2
    length = length/3
    x = 0

    turtle.penup()
    
    turtle.forward(height)
    turtle.right(90)
    turtle.forward(length)
    turtle.right(90)

    turtle.color(get_color(color))
    
    turtle.pendown()
    
    turtle.begin_fill()
    turtle.circle(50)
    turtle.end_fill()


    turtle.penup()

    turtle.goto(pos)

    turtle.right(180)

    

def draw_rectangle(height, length, color):
    height = height * 200
    length = length * 300
    x = 0

    turtle.pendown()
    turtle.color('black')
    
    while x < 2:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1
        


def get_color(color):

    if color == 'red':
        color_code = ('#E32636')

    if color == 'black':
        color_code = ('#000000')

    if color == 'white':
        color_code = ('#FFFFFF')
        
    return color_code



pos = turtle.pos()
turtle.left(90)
draw_circle(200, 300, pos, 'red')
draw_rectangle(1, 1, 'black')

