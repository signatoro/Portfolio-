import turtle

def draw_stripes(height, length, color):
    height = (height*75)/3
    length = length*75
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 1:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)

        turtle.end_fill()

        turtle.right(90)
        turtle.forward(height)
        x = x + 1 

def draw_rectangle(height, length, color):
    height = height *75
    length = length *75
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()
    turtle.right(90)

    while x < 2:
        turtle.forward(length)
        turtle.right(90)
        turtle.forward(height)
        turtle.right(90)

        x = x + 1
        


def get_color(color_wanted):

    if color_wanted == 'white':
        color_code = ("#FFFFFF")
        
    if color_wanted == 'black':
        color_code = ('#000000')

    if color_wanted == 'red':
        color_code = ("#DD0000")

    if color_wanted == 'yellow':
        color_code = ('#FFCE00')
        
    return color_code








turtle.left(90)
draw_stripes(3, 5, 'yellow')
draw_stripes(3, 5, 'red')
draw_stripes(3, 5, 'black')
draw_rectangle(3, 5, 'black')
