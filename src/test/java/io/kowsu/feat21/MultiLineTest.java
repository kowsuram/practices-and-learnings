package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    @created February/28/2024 - 11:22 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
 class MultiLineTest {


    @Test
    void multiLineTest() {
        String alokIndsShare = """
                Alok Industries Limited, is an Indian Textile manufacturing company based in Mumbai. 
                It Is Owned By Reliance Industries .
                Alok Industries Limited is one of India’s largest vertically integrated textile company offering end-to-end solutions through its five core divisions:
                Home Textiles, Cotton Yarn, Apparel Fabric, Garments, Technical Textiles, Textile Accessories and Polyester Yarn.
                Its main business involves weaving, knitting, processing, home textiles, ready made garments and polyester yarns.
                It exports 26% of its products to over 90 countries in the US, Europe, South America, Asia and Africa.
                It's customer base includes multiple renowned brands like Levi's , Walmart , Zara , Calvin Klein , H&M, Tommy Hilfiger , PVH ,
                Tesco , Costco Wholesale , Bestseller , Bershka , Kohl's , NEXT , Pull&Bear , Reliance Retail And Many More. Alok Industries Also Have A Majority stake in a
                Czech re incorporated textile company Mileta which supply its product across the europe region. The export represents 90% of the entire production. 
                Alok Industries have Global Organic Textiles (GOTS), OEKOTEX, Made In Green, Fairtrade, Egyptian Cotton certified, amongst others. including (ISO 9001),
                Environment Management System (ISO 18001), Occupational Health and Safety System (OHSAS 45001), MADE IN GREEN - STeP certification, and OKEOTEX 100.
                """;
        assertEquals("A", String.valueOf(alokIndsShare.charAt(0)));
    }

}




