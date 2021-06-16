package de.captaingoldfish.scim.sdk.keycloak.scim.handler;

public class SyncUtils
{

  private static final String USER_PREFIX = "u-";

  private static final String GROUP_PREFIX = "g-";

  public static String getPublicId(String internalId, boolean isGroup)
  {
    final String prefix = isGroup ? GROUP_PREFIX : USER_PREFIX;
    return prefix + internalId;
  }

  public static String getInternalId(String publishedId)
  {
    if (isGroupMember(publishedId) || isUserMember(publishedId))
    {
      return publishedId.substring(2);
    }
    else
    {
      return publishedId;
    }
  }

  public static boolean isGroupMember(String memberId)
  {
    return memberId.startsWith(GROUP_PREFIX);
  }

  public static boolean isUserMember(String memberId)
  {
    return memberId.startsWith(USER_PREFIX);
  }
}
