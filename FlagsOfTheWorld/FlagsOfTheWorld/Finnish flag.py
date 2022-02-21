import turtle

def draw_base(height, length, color):
    height = height* 25
    length = length* 25
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
    height = 40 *2.5
    length = 100 *2.5
    short_length = 50 *2.5
    short_height = 30 *2.5
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    turtle.forward(height)

    while x < 1:
        turtle.right(90)
        turtle.forward(short_length)
        turtle.right(90)
        turtle.forward(height)

        x = x + 1

    turtle.left(90)
    turtle.forward(short_height)
    turtle.left(90)
    turtle.forward(height)

    x = 0 

    #Long part of the cross
    turtle.right(90)
    turtle.forward(length)
    turtle.left(90)
    turtle.forward(short_height)
    turtle.left(90)
    turtle.forward(length)

    turtle.right(90)
    turtle.forward(height)
    turtle.left(90)
    turtle.forward(short_height)

    turtle.left(90)
    turtle.forward(height)
    turtle.right(90)
    turtle.forward(short_length)

    turtle.left(90)
    turtle.forward(short_height)

    turtle.end_fill()

    turtle.forward(height)


def draw_rectangle(height, length, color):
    height = height* 25
    length = length* 25
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

    if color_wanted == 'blue':
        color_code = ('#003580')

    return color_code

turtle.left(90)
draw_base(11, 18, 'white')
draw_cross(11, 18, 'blue')
draw_rectangle(11, 18, 'black')
