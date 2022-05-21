package model.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CoinConnectionDAO {
  public static void main(String[] args) throws Exception {

    final String url = "https://crypto.com/price";

    try {
      // atribui o valor da url a um documento
      final Document document = Jsoup.connect(url).get();

      int c = 0;

      // percorre a tabela do site
      for (org.jsoup.nodes.Element row : document
          .select("table.chakra-table.css-1bveei3 tr")) {
        if (c < 10) {
          if (row.select(".css-1kvo0ra").text().equals("")) {
            continue;
          } else {
            // pega o nome de cada criptomoeda
            final String nome = row.select(
                ".css-o2rp9n.chakra-text")
                .text();

            // pega a tag de cada moeda
            final String tag = row.select(".css-ft1qn5.chakra-text").text();

            // pega o preço atual de cada moeda
            String preco_usd = row.select(".css-b1ilzc").text();
            preco_usd = preco_usd.replace("$", ""); // remove os '$'
            preco_usd = preco_usd.replace(",", ""); // remove os ','

            // salva os preços como double
            final Double preco = Double.parseDouble(preco_usd);

            // pega a variação de cada moeda nas últimas 24h (com o símbolo de %)
            String var24_perc = row.select("td.css-1b7j986:nth-of-type(5)").text();
            var24_perc = var24_perc.replaceAll("%", ""); // remove os '%'

            // salva a variação como double
            final Double var24 = Double.parseDouble(var24_perc);

            System.out.println(nome + " | " + tag + " | " + preco + " | " + var24);
          }
          c++;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
