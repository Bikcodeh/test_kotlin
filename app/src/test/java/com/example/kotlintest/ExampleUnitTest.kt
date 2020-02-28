package com.example.kotlintest

import com.example.kotlintest.adapter.UserAdapter
import com.example.kotlintest.model.main.User
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun look_size_model_list_adapter(){

        val user = User()
        user.name = "Victor"

        val lista2 = mutableListOf<User>()
        lista2.add(user)

        val adapter = UserAdapter()
        adapter.userAdapter(lista2)

        assertTrue(adapter.itemCount > 0)
    }

    @Test
    fun adapter_is_not_null(){
        val adapter = UserAdapter()

        assertNotNull(adapter)
    }
}
