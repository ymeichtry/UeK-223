package main.java.ch.zli.m223.auth;

import io.smallrye.jwt.build.Jwt;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;

@Path("/auth")
public class AuthResource {

    private PrivateKey loadPrivateKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get("src/main/resources/privateKey.pem"));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }

    @POST
    @Path("/token")
    public Response generateToken() {
        try {
            PrivateKey privateKey = loadPrivateKey();

            HashMap<String, Object> claims = new HashMap<>();
            claims.put("name", "TestUser");
            claims.put("role", "Admin");

            String token = Jwt.claims(claims)
                             .jws()
                             .sign(privateKey);

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
