package com.ojas.gst.dao;

import com.ojas.gst.entity.AccessToken;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface AccessTokenDao extends Dao<AccessToken, Long>
{
    AccessToken findByToken(String accessTokenString);
}
