package spkrash.krashinc.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 14.12.2016.
 */
public class GeoIpServiceTests {

   @Test
   public void testMyIp(){
      GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.215.10.130");
      assertEquals(geoIP.getCountryCode(), "UKR");
   }

   @Test
   public void testInvalidIp(){
      GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("91.215.10.xxx");
      assertEquals(geoIP.getCountryCode(), "UKR");
   }
}
