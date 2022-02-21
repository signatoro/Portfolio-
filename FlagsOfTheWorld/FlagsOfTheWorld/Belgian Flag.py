import turtle

def draw_stripes(height, length, color):
    height = height* 13
    length = (length* 15)/3
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(length)
        turtle.left(90)
        turtle.forward(height)
        turtle.left(90)

        x = x + 1
    turtle.end_fill()

    turtle.forward(length)

def draw_rectangle(height, length, color):
    height = height* 13
    length = length* 15
    x = 0

    turtle.color(get_color(color))

    turtle.left(90)

    while x < 2:
        turtle.forward(height)
        turtle.left(90)
        turtle.forward(length)
        turtle.left(90)

        x = x + 1
        
def get_color(color_wanted):


    if color_wanted == 'white':
        color_code = ("#FFFFFF")

    if color_wanted == 'black':
        color_code = ('#000000')

    if color_wanted == 'yellow':
        color_code = ('#FAE042')

    if color_wanted == 'red':
        color_code = ('#ED2939')

    return color_code


draw_stripes(10, 10, 'black')
draw_stripes(10, 10, 'yellow')
draw_stripes(10, 10, 'red')
draw_rectangle(10, 10, 'black')
