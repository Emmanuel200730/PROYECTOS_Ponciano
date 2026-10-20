package com.example.music_app

import android.R
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import java.util.concurrent.ConcurrentLinkedDeque


class DatabaseHelper(context: Context) : SQLiteOpenHelper (
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION,

){

    companion object{

        private const val DATABASE_NAME = "musica.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_USUARIOS = "usuarios"
        private const val COL_ID = "ID"
        private const val COL_NOMBRE = "nombre"
        private const val COL_CORREO = "correo"
        private const val COL_PASSWORD = "password"
    }

    //metodo para crear base de datos

    override fun onCreate(p0: SQLiteDatabase?) {
        val crearTablausuarios = """
            CREATE TABLE $TABLE_USUARIOS (
              $COL_ID INTEGER PRIMARY KEY  AUTOINCREMENT,
              $COL_NOMBRE TEXT NOT NULL,
              $COL_CORREO TEXT NOT NULL UNIQUE,
              $COL_PASSWORD TEXT NOT NULL
            
            )
        """.trimIndent()



        //CREAR tabla de sql

        p0?.execSQL(crearTablausuarios)

    }

    //metodo para actualizar base de datos

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
        onCreate(p0)
    }

    //METODO PARA INSERTAR REGISTRO

    fun registrarUsuario(nombre: String, correo: String, password: String) : Boolean{

        //CREAR VARIABLE PARA QUE LA BSE DE DATOS SE PUEDA MODIFICAR
        val p0 = writableDatabase

        //crear variable para recibir los datos que escribe el usuario
        val datos = ContentValues().apply {
            put(COL_NOMBRE, nombre)
            put(COL_CORREO, correo)
            put(COL_PASSWORD, password)
        }

        //insertar datos en la tabla
         val resultado = p0.insert(TABLE_USUARIOS, null, datos)

        //cerrar conexion con la BD
        p0.close()


        //comparar el valor del resultado de la insercion y regresarlo como boolean
        return resultado != -1L

    }

}