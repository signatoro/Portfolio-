import turtle

def draw_stripes(height, length, color):
    height = height * 30
    length = length * 50
    x = 0 

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(height/3)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1
    turtle.end_fill()

    turtle.forward(height/3)

def draw_rectangle(height, length, color):
    height = height * 30
    length = length * 50
    x = 0

    turtle.color(get_color(color))
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

    if color_wanted == 'green':
        color_code = ('#00966E')
        
    if color_wanted == 'red':
        color_code = ("#D62612")

    return color_code


turtle.left(90)
draw_stripes(9, 9, 'red')
draw_stripes(9, 9, 'green')
draw_stripes(9, 9, 'white')
draw_rectangle(9, 9, 'black')
