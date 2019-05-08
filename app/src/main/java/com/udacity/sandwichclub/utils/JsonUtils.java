package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject nome_do_sanduiche = new JSONObject(json).getJSONObject("name");
            String nome_principal = nome_do_sanduiche.getString("mainName");
            List<String> nome_vulgar = new ArrayList<>();
            for (int i = 0; i < nome_do_sanduiche.getJSONArray("alsoKnownAs").length(); i++) {
                nome_vulgar.add(nome_do_sanduiche.getJSONArray("alsoKnownAs").getString(i));
            }
            String lugar_de_origem = new JSONObject(json).getString("placeOfOrigin");
            String descricao = new JSONObject(json).getString("description");
            String imagem = new JSONObject(json).getString("image");
            List<String> ingredientes = new ArrayList<>();
            for (int i = 0; i < new JSONObject(json).getJSONArray("ingredients").length(); i++) {
                ingredientes.add(new JSONObject(json).getJSONArray("ingredients").getString(i));
            }
            return new Sandwich(nome_principal, nome_vulgar, lugar_de_origem, descricao, imagem, ingredientes);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
