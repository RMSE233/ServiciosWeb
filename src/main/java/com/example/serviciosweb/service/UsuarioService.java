
package com.example.serviciosweb.service;

import com.example.serviciosweb.model.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private static final String URL =
            "https://sqpvqkkdfgtzdgrjrgxs.supabase.co/rest/v1/customers?select=*";

    private static final String API_KEY =
            "sb_publishable_vIJdi0L7Kd2XtbzaTaFSgg_xvbo3eAf";

    private final HttpClient cliente = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Usuario> obtenerUsuarios()
            throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .timeout(Duration.ofSeconds(15))
                .header("apikey", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException(
                    "Error al obtener los usuarios. Código HTTP: "
                            + response.statusCode()
                            + " - " + response.body()
            );
        }

        JsonNode datos = mapper.readTree(response.body());

        if (!datos.isArray()) {
            throw new IOException(
                    "La respuesta no contiene un formato JSON válido"
            );
        }

        List<Usuario> usuarios = new ArrayList<>();

        for (JsonNode nodo : datos) {

            Usuario usuario = new Usuario(
                    nodo.path("id").asInt(),
                    nodo.path("first_name").asText(""),
                    nodo.path("last_name").asText(""),
                    nodo.path("email").asText(""),
                    nodo.path("phone").asText(""),
                    nodo.path("date_of_birth").asText(""),
                    nodo.path("country").asText(""),
                    nodo.path("city").asText(""),
                    nodo.path("address").asText(""),
                    nodo.path("annual_income").asDouble(0.0),
                    nodo.path("credit_score").asInt(0),
                    nodo.path("has_unpaid_debt").asBoolean(false),
                    nodo.path("unpaid_debt_amount").asDouble(0.0),
                    nodo.path("status").asText("")
            );

            usuarios.add(usuario);
        }

        return usuarios;
    }
}
