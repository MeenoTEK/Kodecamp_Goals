package com.tutorials.kodecampgoals.data

import android.content.Context
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.tutorials.kodecampgoals.R

val textList = listOf(
    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
            "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
            "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +
            "optio, eaque rerum! Provident similique accusantium nemo autem. Veritatis\n" +
            "obcaecati tenetur iure eius earum ut molestias architecto voluptate aliquam\n" +
            "nihil, eveniet aliquid culpa officia aut! Impedit sit sunt quaerat, odit,\n" +
            "tenetur error, harum nesciunt ipsum debitis quas aliquid. Reprehenderit,\n" +
            "quia.",
    "Quo neque error repudiandae fuga? Ipsa laudantium molestias eos\n" +
            "sapiente officiis modi at sunt excepturi expedita sint? Sed quibusdam\n" +
            "recusandae alias error harum maxime adipisci amet laborum. Perspiciatis\n" +
            "minima nesciunt dolorem! Officiis iure rerum voluptates a cumque velit\n" +
            "quibusdam sed amet tempora. Sit laborum ab, eius fugit doloribus tenetur\n" +
            "fugiat, temporibus enim commodi iusto libero magni deleniti quod quam\n" +
            "consequuntur! Commodi minima excepturi repudiandae velit hic maxime\n" +
            "doloremque.",
    "Quaerat provident commodi consectetur veniam similique ad\n" +
            "earum omnis ipsum saepe, voluptas, hic voluptates pariatur est explicabo\n" +
            "fugiat, dolorum eligendi quam cupiditate excepturi mollitia maiores labore\n" +
            "suscipit quas? Nulla, placeat. Voluptatem quaerat non architecto ab laudantium\n" +
            "modi minima sunt esse temporibus sint culpa, recusandae aliquam numquam\n" +
            "totam ratione voluptas quod exercitationem fuga. Possimus quis earum veniam\n" +
            "quasi aliquam eligendi, placeat qui corporis!"


)


fun getAllGoals():List<Goal>{

    val list = listOf(
        Goal(
            id = 1,
            title = "New Chanel",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 1, 2023",
            dateDue = "Nov 2, 2023",
            category = "Shopping"

        ), Goal(
            id = 2,
            title = "New Balenciaga",
            desc = textList.random(),
            priority = 1,
            dateCreated = "Nov 1, 2023",
            dateDue = "Nov 10, 2023",
            category = "Shopping"

        ), Goal(
            id = 3,
            title = "New Louis Vuitton",
            desc = textList.random(),
            priority = 2,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Shopping"

        ), Goal(
            id = 4,
            title = "New Slides",
            desc = textList.random(),
            priority = 1,
            dateCreated = "Nov 3, 2023",
            dateDue = "Nov 12, 2023",
            category = "Shopping"

        ), Goal(
            id = 5,
            title = "New Versace watch",
            desc = textList.random(),
            priority = 1,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Shopping"

        ), Goal(
            id = 6,
            title = "Run 20 laps",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Sports"

        ), Goal(
            id = 7,
            title = "Run 200 laps",
            desc = textList.random(),
            priority = 1,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Sports"

        ),Goal(
            id = 8,
            title = "Do 30 sit-ups",
            desc = textList.random(),
            priority = 2,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Sports"

        ),Goal(
            id = 9,
            title = "Do 15 push-ups",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Sports"

        ),Goal(
            id = 10,
            title = "Do 10 pull-ups",
            desc = textList.random(),
            priority = 2,
            dateCreated = "Nov 10, 2023",
            dateDue = "Nov 22, 2023",
            category = "Sports"

        ),Goal(
            id = 11,
            title = "Start food gourmet",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 3, 2023",
            dateDue = "Nov 4, 2023",
            category = "Foods"

        ),Goal(
            id = 12,
            title = "Try crabs dishes",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 5, 2023",
            dateDue = "Nov 6, 2023",
            category = "Foods"

        ),Goal(
            id = 13,
            title = "Try Lobster dishes",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 7, 2023",
            dateDue = "Nov 8, 2023",
            category = "Foods"

        ),Goal(
            id = 14,
            title = "Try Shark dishes",
            desc = textList.random(),
            priority = 3,
            dateCreated = "Nov 9, 2023",
            dateDue = "Nov 10, 2023",
            category = "Foods"

        ),Goal(
            id = 15,
            title = "Try Spicy dishes",
            desc = textList.random(),
            priority = 1,
            dateCreated = "Nov 11, 2023",
            dateDue = "Nov 20, 2023",
            category = "Foods"

        ),
    )

    return list
}

 fun Context.setPriorityColor(priority:Int):ColorStateList{
     val tintList:ColorStateList
     return when(priority){
        1->{
             tintList = ColorStateList.valueOf( ContextCompat.getColor(
                this,
                R.color.green
            ))
            tintList

        }
        2->{
            tintList = ColorStateList.valueOf( ContextCompat.getColor(
                this,
                R.color.yellow
            ))
            tintList
        }
        else->{
            tintList = ColorStateList.valueOf( ContextCompat.getColor(
                this,
                R.color.red
            ))
            tintList
        }
    }
}
