import turtle

def draw_stripes(height, length, color):
    height = height/2
    length = length
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

    turtle.forward(height)


def draw_triangle(height, color):
    height = height
    x = 0

    turtle.color(color)
    turtle.begin_fill()
    turtle.left(180)

    while x < 3:
        turtle.forward(height)
        turtle.left(90)
        turtle.left(30)
        x = x + 1
    turtle.end_fill()

def draw_rectangle(height, length, color):
    height = height
    length = length
    x = 0
    turtle.color(get_color(color))

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

    if color_wanted == 'blue':
        color_code = ('#11457E')
        
    if color_wanted == 'red':
        color_code = ("#D7141A")

    return color_code







turtle.left(90)
draw_stripes(200, 300, 'red')
draw_stripes(200, 300, 'white')
draw_triangle(200, 'blue')
draw_rectangle(200, 300, 'black')





