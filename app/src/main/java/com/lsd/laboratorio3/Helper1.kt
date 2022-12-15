package com.lsd.laboratorio3

import java.io.*
import android.util.Log
import android.app.Activity
import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset


class Helper1 {

    constructor()

    fun guardar(postulante: Postulante, context:Context) {
        var arraylist1 = ArrayList<String>()
        val file = File(context.filesDir, "postulantes.txt")
        val dato: String = "Nombre: "+postulante.nombre+ " *ApellidoPaterno: "+postulante.apellidoP+ " *ApellidoMaterno: "+postulante.apellidoM+ " *Fecha: "+postulante.fechaN+" *Coledio: "+postulante.colegio+" *Carrera: "+postulante.carrera
        //if (context.fileList().contains("postulantes.txt")) {
            try {

                    FileOutputStream(file).use { fos ->
                        OutputStreamWriter(fos, Charset.defaultCharset()).use { osw ->
                            BufferedWriter(osw).use { bf -> bf.write(dato) }
                        }
                    }

            } catch (e: IOException) {
            }


    }

    fun leer(context: Context) : ArrayList<String> {
        var arraylist = ArrayList<String>()
        try {
            val archivo = InputStreamReader(context.openFileInput("postulantes.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            val todo = StringBuilder()
            while (linea != null) {
                todo.append(linea + "\n")
                arraylist.add(linea)
                linea = br.readLine()
            }
            br.close()
            archivo.close()
            Log.i("", "metodo leer" + todo);
        } catch (e: IOException) {
        }



        return  arraylist
    }
}