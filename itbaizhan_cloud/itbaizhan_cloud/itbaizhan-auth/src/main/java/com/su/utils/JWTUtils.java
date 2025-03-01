package com.su.utils;


import org.jose4j.json.JsonUtil;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import java.security.PrivateKey;
import java.security.PublicKey;


/**
 * 生成Token工具类
 */
public class JWTUtils {
    //私钥
    public static final String privateJson ="{\"kty\":\"RSA\",\"n\":\"p869F6HsHLul_bdahWBsE1MYOr7H8SJPxorIfo-Z2qFw56IUzUUmoZrr98L0933rDoKer-Usp1daS6dGPftu2FiWuO6B8O8r3JgqnLU13OL_gW0cgunNhmTIra0ScZFp9AeLLmZ6Ft_8Iozpin92-uysBlSQ7c4MdxtX-VQI-ciHZudBIXrP_JDeVo0KamRbhVlhB_98V9rX4EmDm2OcGiOJENDN3_fDhXH_jMsyzUdM3aLEzM80m26Pm5ZeQhefrZYSUU105QRD5W93VFJ-Wl5FdL6wjOejO3-d5jEfA29QxpIZpLpeqtZT2A4e8_LyUeBj6WNNKCfAC20OefrdVQ\",\"e\":\"AQAB\",\"d\":\"AzOiLySqAbIBMgTQ-j6ozo_qjwO2WA8LSMgQ7hHqgdMhjsMsf0PMlPnves1HtBQn4Lbpylnb9FUUljZwFD0rSX9Gius-uUcwRffKR637w9s55vEwbCgEAZvZKgUlbFt1qHq0s13bAlDjjuYzi4QF6WDhdwfJ3HEEEwlcxZdOn4i7FOaEKiiyUBxbDCTQ0JBvcW84u_62z8NpfUb5AIpLA0EHh1fuQswYgfgabVohVztObKrfnk5VZ-m7fgLAyezgSjFOTRVt5aoLyAl7X6JnzRu4OhWqUXva2rAi1GXhzKRplrLzf3GsdmDv-FFOFqpAYiA0BDfWcutwwdH3QXEAoQ\",\"p\":\"vgLsJIFpQ4fALeXtIFsYwvFbQistqmB-NY50f61MpP3O8vuXa_P5JfVG7r68V0m6nIv5-4r37GaCeTkjGn70mmI4-GGpCv6lJmdd92ZGpKLbz9AVnTUkiWUR7t2KsfWkpv60IYLMFwZgfedNVWzEdO-dk3TAPA2bcGXBWncNVuE\",\"q\":\"4hXFOEviS6WgUrT_vLx7NjJwOVS8FwiiCZ6Han99vzE0VZWVC_1-j8O86DV8rHQuf0qEnAr_7do7Wucia2030z2PDqFWG5Ii1TSECAS_nj1MK88qE5F2BLlxnwYMMD5a4jIUoGAQ3VMiUa7F7Lshg3cxtQVGlERaY3ylBE1luPU\",\"dp\":\"cs23OdNK83dY4SJz5EHGMzq6xb7q529HsjoxH1do4KNNX7gtZBdTqOCKjAOILkEo1B8q2hW7-ARzvqSMFh0w0vqXq1LuXOtAg3Se7LTJ5_1STDxQYtzSB4WekTEf9KgTZKat1TV-9EZxFIElU4DVLkX8cjRvVZlvGjkQ2wTldWE\",\"dq\":\"k1IeVmXUSvjdNKeu8XxcSV-qkyEtA1FjzSLZGMOE3B4i_RXgrpR7cRDaOvIHkJSQa-_R46CjToljHgP5AMmFlAfL_XuSEZszSXzUACmf92v4A6AVyfSCU-fHKxmUvacUL8r0d-DBfIccmN9rJ6x01SbJZCzQ5fJ4d9WT7e7FNzU\",\"qi\":\"kTv8mgVzJAfQxhCrIHA-p7OGqFcKJq1kJyyEBsQJCTb_Q47gdCXu-xetLiUJ3oxQSB4siFxh01PMCptvgjlmlRD2gqsgoBx_2Cw7wyGeuURgOUk6WQNEBzkIzrtfeuYhDtKPtOn9VmKLdX_MIaHt0nq53foxlPXN5YW0VhEjukQ\"}";
    public static final String publicJson = "{\"kty\":\"RSA\",\"n\":\"p869F6HsHLul_bdahWBsE1MYOr7H8SJPxorIfo-Z2qFw56IUzUUmoZrr98L0933rDoKer-Usp1daS6dGPftu2FiWuO6B8O8r3JgqnLU13OL_gW0cgunNhmTIra0ScZFp9AeLLmZ6Ft_8Iozpin92-uysBlSQ7c4MdxtX-VQI-ciHZudBIXrP_JDeVo0KamRbhVlhB_98V9rX4EmDm2OcGiOJENDN3_fDhXH_jMsyzUdM3aLEzM80m26Pm5ZeQhefrZYSUU105QRD5W93VFJ-Wl5FdL6wjOejO3-d5jEfA29QxpIZpLpeqtZT2A4e8_LyUeBj6WNNKCfAC20OefrdVQ\",\"e\":\"AQAB\"}";

    /**
     * 生成token
     * @param userId  用户id
     * @param username 用户名称
     * @return
     */
    public static String sign(Long userId,String username) throws JoseException {
        //载荷
        JwtClaims jwtClaims = new JwtClaims();
        //谁声明的令牌并签署了他
        jwtClaims.setIssuer("abcd");
        //令牌将被发送的对象
        jwtClaims.setAudience("audience");
        //失效时间（从现在开始10分钟）
        jwtClaims.setExpirationTimeMinutesInTheFuture(10000);
        //令牌的唯一标识符
        jwtClaims.setGeneratedJwtId();
        // 当令牌被发布/创建时（现在）
        jwtClaims.setIssuedAtToNow();
        // 在此之前，令牌无效（2分钟前）
        jwtClaims.setNotBeforeMinutesInThePast(2);
        // 主题 ,是令牌的对象
        jwtClaims.setSubject("subject");
        // 可以添加关于主题的附加 声明/属性
        jwtClaims.setClaim("userId", userId);
        jwtClaims.setClaim("username", username);

        //2.签名(对头部和载荷加密)
        JsonWebSignature jws = new JsonWebSignature();
        //赋值载荷
        jws.setPayload(jwtClaims.toJson());

        //3.jwt使用私钥加密
        PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateJson)).getPrivateKey();
        jws.setKey(privateKey);

        //4.设置关键kid
        jws.setKeyIdHeaderValue("keyId");

        //5.设置签名算法
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        String jwt = jws.getCompactSerialization();
        return jwt;


    }
    public static void checkJson(String token) throws JoseException, InvalidJwtException {
        //获取公钥
        PublicKey publicKey = new RsaJsonWebKey(JsonUtil.parseJson(publicJson)).getPublicKey();
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setAllowedClockSkewInSeconds(30) // 允许在验证基于时间的令牌时留有一定的余地，以计算时钟偏差。单位/秒
                .setRequireSubject() // 主题声明
                .setExpectedIssuer("abcd") // JWT需要由谁来发布,用来验证 发布人
                .setExpectedAudience("audience") // JWT的目的是给谁, 用来验证观众
                .setVerificationKey(publicKey) // 用公钥验证签名 ,验证秘钥
                .setJwsAlgorithmConstraints( // 只允许在给定上下文中预期的签名算法,使用指定的算法验证
                        new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.WHITELIST, // 白名单
                                AlgorithmIdentifiers.RSA_USING_SHA256))
                .build();
        JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
        System.out.println(jwtClaims);
    }



    public static void main(String[] args) throws JoseException, InvalidJwtException {
         /*{"kty":"RSA","n":"p869F6HsHLul_bdahWBsE1MYOr7H8SJPxorIfo-Z2qFw56IUzUUmoZrr98L0933rDoKer-Usp1daS6dGPftu2FiWuO6B8O8r3JgqnLU13OL_gW0cgunNhmTIra0ScZFp9AeLLmZ6Ft_8Iozpin92-uysBlSQ7c4MdxtX-VQI-ciHZudBIXrP_JDeVo0KamRbhVlhB_98V9rX4EmDm2OcGiOJENDN3_fDhXH_jMsyzUdM3aLEzM80m26Pm5ZeQhefrZYSUU105QRD5W93VFJ-Wl5FdL6wjOejO3-d5jEfA29QxpIZpLpeqtZT2A4e8_LyUeBj6WNNKCfAC20OefrdVQ","e":"AQAB"}
        {"kty":"RSA","n":"p869F6HsHLul_bdahWBsE1MYOr7H8SJPxorIfo-Z2qFw56IUzUUmoZrr98L0933rDoKer-Usp1daS6dGPftu2FiWuO6B8O8r3JgqnLU13OL_gW0cgunNhmTIra0ScZFp9AeLLmZ6Ft_8Iozpin92-uysBlSQ7c4MdxtX-VQI-ciHZudBIXrP_JDeVo0KamRbhVlhB_98V9rX4EmDm2OcGiOJENDN3_fDhXH_jMsyzUdM3aLEzM80m26Pm5ZeQhefrZYSUU105QRD5W93VFJ-Wl5FdL6wjOejO3-d5jEfA29QxpIZpLpeqtZT2A4e8_LyUeBj6WNNKCfAC20OefrdVQ","e":"AQAB","d":"AzOiLySqAbIBMgTQ-j6ozo_qjwO2WA8LSMgQ7hHqgdMhjsMsf0PMlPnves1HtBQn4Lbpylnb9FUUljZwFD0rSX9Gius-uUcwRffKR637w9s55vEwbCgEAZvZKgUlbFt1qHq0s13bAlDjjuYzi4QF6WDhdwfJ3HEEEwlcxZdOn4i7FOaEKiiyUBxbDCTQ0JBvcW84u_62z8NpfUb5AIpLA0EHh1fuQswYgfgabVohVztObKrfnk5VZ-m7fgLAyezgSjFOTRVt5aoLyAl7X6JnzRu4OhWqUXva2rAi1GXhzKRplrLzf3GsdmDv-FFOFqpAYiA0BDfWcutwwdH3QXEAoQ","p":"vgLsJIFpQ4fALeXtIFsYwvFbQistqmB-NY50f61MpP3O8vuXa_P5JfVG7r68V0m6nIv5-4r37GaCeTkjGn70mmI4-GGpCv6lJmdd92ZGpKLbz9AVnTUkiWUR7t2KsfWkpv60IYLMFwZgfedNVWzEdO-dk3TAPA2bcGXBWncNVuE","q":"4hXFOEviS6WgUrT_vLx7NjJwOVS8FwiiCZ6Han99vzE0VZWVC_1-j8O86DV8rHQuf0qEnAr_7do7Wucia2030z2PDqFWG5Ii1TSECAS_nj1MK88qE5F2BLlxnwYMMD5a4jIUoGAQ3VMiUa7F7Lshg3cxtQVGlERaY3ylBE1luPU","dp":"cs23OdNK83dY4SJz5EHGMzq6xb7q529HsjoxH1do4KNNX7gtZBdTqOCKjAOILkEo1B8q2hW7-ARzvqSMFh0w0vqXq1LuXOtAg3Se7LTJ5_1STDxQYtzSB4WekTEf9KgTZKat1TV-9EZxFIElU4DVLkX8cjRvVZlvGjkQ2wTldWE","dq":"k1IeVmXUSvjdNKeu8XxcSV-qkyEtA1FjzSLZGMOE3B4i_RXgrpR7cRDaOvIHkJSQa-_R46CjToljHgP5AMmFlAfL_XuSEZszSXzUACmf92v4A6AVyfSCU-fHKxmUvacUL8r0d-DBfIccmN9rJ6x01SbJZCzQ5fJ4d9WT7e7FNzU","qi":"kTv8mgVzJAfQxhCrIHA-p7OGqFcKJq1kJyyEBsQJCTb_Q47gdCXu-xetLiUJ3oxQSB4siFxh01PMCptvgjlmlRD2gqsgoBx_2Cw7wyGeuURgOUk6WQNEBzkIzrtfeuYhDtKPtOn9VmKLdX_MIaHt0nq53foxlPXN5YW0VhEjukQ"}
*/

        //生成公钥和私钥
        /*RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        //生成公钥(解密)
        String publicJson = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        //生成私钥（加密）
        String privateJson = rsaJsonWebKey.toJson(JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
        System.out.println(publicJson);
        System.out.println(privateJson);*/
        String jwt = sign(1001L, "itbaizhan");
        System.out.println(jwt);
        checkJson(jwt);
    }

}
