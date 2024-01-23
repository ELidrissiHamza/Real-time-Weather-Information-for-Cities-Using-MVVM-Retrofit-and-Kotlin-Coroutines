package com.example.weatherapp.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Classe responsable de la configuration de l'API pour les appels réseau.
 * Elle utilise Retrofit pour créer le service d'API à partir de l'interface ApiService.
 */
class ApiConfig {

    companion object {

        /**
         * Fonction statique pour obtenir une instance du service d'API.
         */
        fun getApiService(): ApiService {

            // Intercepteur pour les journaux de réponse API
            val loggingInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            // Client OkHttpClient avec l'intercepteur ajouté
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            // Configuration de Retrofit avec l'URL de base, le convertisseur Gson et le client OkHttpClient
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/") // URL de base de l'API météo
                .addConverterFactory(GsonConverterFactory.create()) // Convertisseur Gson pour traiter la réponse JSON
                .client(client)
                .build()

            // Création et retour du service d'API en utilisant l'interface ApiService
            return retrofit.create(ApiService::class.java)
        }

        /**
         * Clé d'API utilisée pour les appels à l'API météo.
         * Remarque : Il est préférable de ne pas stocker la clé d'API directement dans le code source.
         * Ceci est utilisé ici uniquement pour illustrer le concept.
         */
        const val API_KEY = "fab9fcbfc45e4111874143526233112"
    }
}
