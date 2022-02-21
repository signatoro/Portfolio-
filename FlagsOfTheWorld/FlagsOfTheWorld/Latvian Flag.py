import turtle

def draw_base(height, length, color):
    height = height* 10
    length = length* 20
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

def draw_stripe(height, length, color):
    base_height = 80
    stripe_height = 40
    length = length*20
    x = 0

    turtle.forward(base_height)
    
    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(stripe_height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1
        
    turtle.end_fill()
    turtle.backward(base_height)
    
def draw_rectangle(height, length, color):
    height = height* 10
    length = length* 20
    x = 0

    turtle.color(get_color(color))

    while x < 2:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1

def get_color(color_wanted):

    if color_wanted == 'white':
        color_code = ("#FFFFFF")

    if color_wanted == 'black':
        color_code = ('#000000')
        
    if color_wanted == 'red':
        color_code = ("#9E3039")
    
    return color_code

turtle.left(90)
draw_base(20, 20, 'red')
draw_stripe(20, 20, 'white')
draw_rectangle(20, 20, 'black')
