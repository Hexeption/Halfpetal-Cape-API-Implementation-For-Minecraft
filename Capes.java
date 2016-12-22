import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Hexeption on 04/09/2016.
 */
public class Capes {

    /**
     * To implement this into your client add Capes.getCapes(profile, map) in the SkinManager class
     * inside the (loadProfileTextures) below (final Map<Type, MinecraftProfileTexture> map = Maps.<Type, MinecraftProfileTexture>newHashMap();)
     */
    
    /**
     * Downloads the Cape image from the Halfpetal Cape API and adds it to the skin map.
     *
     * @param gameProfile
     * @param skinMap
     */
    public static void getCapes(GameProfile gameProfile, Map skinMap) {

        try {
            String formattedUUID = formatUUID(gameProfile.getId());

            skinMap.put(MinecraftProfileTexture.Type.CAPE, new MinecraftProfileTexture("http://capes.halfpetal.com/api/v1/" + formattedUUID + "/getCape", null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to format the UUID from (33e602eb-2f7e-4a84-8606-aaa1ac4faa68) to (33e602eb2f7e4a848606aaa1ac4faa68) to be used in the api.
     *
     * @param uuid
     * @return
     */
    private static String formatUUID(UUID uuid) {

        return uuid.toString().replaceAll("-", "");
    }
}
