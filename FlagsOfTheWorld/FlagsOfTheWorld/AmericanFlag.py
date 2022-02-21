import tkinter
import turtle


def draw_rectangle(length, height, color):
    length = length * 200
    height = height/13
    x = 0

    turtle.speed(1000000)
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


	
def draw_blue_bit(length, height, color):

	length = length * 200
	height = height * 200

	turtle.color(get_color(color))
	turtle.begin_fill()
	
	for num in range(1,3):
	    turtle.right(90)
	    turtle.forward(length)
	    turtle.right(90)
	    turtle.forward(height)

	turtle.end_fill()
	turtle.backward(height)



def star_draw(size, color):

    size = 1.9/.4
    dis_between_star = (0.0633 * 200) * 1.3
    height_between_rows = 0.0538 * 200
    beginning_pos = turtle.pos()
    repeat = 0
    num_of_star = 0
    row_num = 1 

    turtle.forward(height_between_rows)
    turtle.right(90)

    for num in range(1, 5):
        row_6_star(size, dis_between_star, height_between_rows, color)

        row_num = row_num + 1 

        turtle.goto(beginning_pos)
        turtle.left(90)
        turtle.forward(height_between_rows* row_num)
        turtle.right(90)
        turtle.forward(dis_between_star/1.5)

        row_5_star(size, dis_between_star, height_between_rows, color)

        row_num = row_num + 1

        turtle.goto(beginning_pos)
        turtle.left(90)
        turtle.forward(height_between_rows* row_num)
        turtle.right(90)
        
    row_6_star(size, dis_between_star, height_between_rows, color)
    turtle.goto(beginning_pos)
    turtle.left(90)
    turtle.forward(height_between_rows*10)



    



def row_6_star(size, dis_between_star, height_between_rows, color):
    repeat = 0
    num_of_star = 0

    turtle.speed(1000000)


    while num_of_star < 6:
        turtle.forward(dis_between_star)

        turtle.pendown()
        turtle.color(get_color(color))
        turtle.begin_fill()

        while repeat < 5:
            turtle.forward(size)
            turtle.left(72)
            turtle.forward(size)
            turtle.right(144)
            repeat = repeat + 1

        turtle.end_fill()
        turtle.forward(size)
        turtle.penup()

        repeat = 0 
        num_of_star = num_of_star + 1

    num_of_star = 0 

def row_5_star(size, dis_between_star, height_between_rows, color):
    repeat = 0
    num_of_star = 0

    turtle.speed(100000)

    while num_of_star < 5:
        turtle.forward(dis_between_star)
        
        turtle.pendown()
        turtle.color(get_color(color))
        turtle.begin_fill()

        while repeat < 5:
            turtle.forward(size)
            turtle.left(72)
            turtle.forward(size)
            turtle.right(144)
            repeat = repeat + 1

        turtle.end_fill()
        turtle.forward(size)
        turtle.penup()

        repeat = 0 
        num_of_star = num_of_star + 1
    
    num_of_star = 0 

def draw_flag(height):
    height = height * 200
    length = height * 1.9

    turtle.color ("black")
    turtle.pendown()

    for num in range(0,2):
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        turtle.forward(height)

def get_color(color):
    r = 0
    g = 0
    b = 0
    
    if color == "white":
        r = 1.00
        g = 1.00
        b = 1.00
    elif color == "red":
        r = .698
        g = .132
        b = .203
    elif color == "blue":
        r = .234
        g = .233
        b = .430	

    return r, g, b
    
     
    
    







turtle.speed(100)
turtle.left(90)
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")
draw_rectangle(1.9, 200, "white")
draw_rectangle(1.9, 200, "red")

draw_blue_bit(.76, 0.5385, "blue" )

star_draw(0.0616, "white")

draw_flag(1)




