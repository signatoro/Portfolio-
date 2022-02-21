import turtle

def draw_base(height, length, color):
    height = height* 10
    length = length* 10
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1

    turtle.end_fill()

def draw_cross(height, length, color):
    height = 120
    length = 210
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    turtle.forward(height)

    while x < 2:
        turtle.right(90)
        turtle.forward(height)

        x = x + 1

    turtle.left(90)
    turtle.forward(40)
    turtle.left(90)
    turtle.forward(height)

    x = 0 

    #Long part of the cross
    turtle.right(90)
    turtle.forward(length)
    turtle.left(90)
    turtle.forward(40)
    turtle.left(90)
    turtle.forward(length)

    turtle.right(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.forward(40)

    turtle.left(90)
    turtle.forward(height)
    turtle.right(90)
    turtle.forward(height)

    turtle.left(90)
    turtle.forward(40)

    turtle.end_fill()

    turtle.forward(height)


def draw_rectangle(height, length, color):
    height = height* 10
    length = length* 10
    x = 0

    turtle.color(get_color(color))

    while x < 2:
        turtle.left(90)
        turtle.forward(length)
        turtle.left(90)
        turtle.forward(height)
        x = x + 1 

    
    


def get_color(color_wanted):

    if color_wanted == 'white':
        color_code = ("#FFFFFF")
    
    if color_wanted == 'black':
        color_code = ('#000000')

    if color_wanted == 'red':
        color_code = ('#C60C30')

    return color_code

turtle.left(90)
draw_base(28, 37, 'red')
draw_cross(28, 37, 'white')
draw_rectangle(28, 37, 'black')
