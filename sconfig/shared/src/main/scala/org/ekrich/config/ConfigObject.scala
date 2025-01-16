/**
 * Copyright (C) 2011-2012 Typesafe Inc. <http://typesafe.com>
 */
package org.ekrich.config

import java.{util => ju}

/**
 * Subtype of [[ConfigValue]] representing an object (AKA dictionary or map)
 * value, as in JSON's curly brace `{ "a" : 42 }` syntax.
 *
 * <p> An object may also be viewed as a [[Config]] by calling
 * [[ConfigObject#toConfig]].
 *
 * <p> `ConfigObject` implements `java.util.Map[String, ConfigValue]` so you can
 * use it like a regular Java map. Or call [[#unwrapped]] to unwrap the map to a
 * map with plain Java values rather than `ConfigValue`.
 *
 * <p> Like all [[ConfigValue]] subtypes, `ConfigObject` is immutable. This
 * makes it threadsafe and you never have to create "defensive copies." The
 * mutator methods from `java.util.Map` all throw
 * `java.lang.UnsupportedOperationException`.
 *
 * <p> The [[ConfigValue#valueType]] method on an object returns
 * [[ConfigValueType#OBJECT]].
 *
 * <p> In most cases you want to use the [[Config]] interface rather than this
 * one. Call [[#toConfig]] to convert a `ConfigObject` to a `Config`.
 *
 * <p> The API for a `ConfigObject` is in terms of keys, while the API for a
 * [[Config]] is in terms of path expressions. Conceptually, `ConfigObject` is a
 * tree of maps from keys to values, while a `Config` is a one-level map from
 * paths to values.
 *
 * <p> Use
 * [[ConfigUtil$.joinPath(elements:String*)* ConfigUtil.joinPath(String*)]] and
 * [[ConfigUtil$.splitPath ConfigUtil.splitPath(String)]] to convert between
 * path expressions and individual path elements (keys).
 *
 * <p> A `ConfigObject` may contain null values, which will have
 * [[ConfigValue#valueType]] equal to [[ConfigValueType#NULL]]. If
 * [[ConfigObject#get]] returns Java's null then the key was not present in the
 * parsed file (or wherever this value tree came from). If `get("key")` returns
 * a [[ConfigValue]] with type `ConfigValueType#NULL` then the key was set to
 * null explicitly in the config file.
 *
 * <p> <em>Do not implement interface `ConfigObject` </em>; it should only be
 * implemented by the config library. Arbitrary implementations will not work
 * because the library internals assume a specific concrete implementation.
 * Also, this interface is likely to grow new methods over time, so third-party
 * implementations will break.
 */
trait ConfigObject extends ConfigValue with ju.Map[String, ConfigValue] {

  /**
   * Converts this object to a [[Config]] instance, enabling you to use path
   * expressions to find values in the object. This is a constant-time operation
   * (it is not proportional to the size of the object).
   *
   * @return
   *   a [[Config]] with this object as its root
   */
  def toConfig: Config

  /**
   * Recursively unwraps the object, returning a map from String to whatever
   * plain Java values are unwrapped from the object's values.
   *
   * @return
   *   a `java.util.Map` containing plain Java objects
   */
  override def unwrapped: ju.Map[String, AnyRef]

  override def withFallback(other: ConfigMergeable): ConfigObject

  /**
   * Gets a [[ConfigValue]] at the given key, or returns null if there is no
   * value. The returned [[ConfigValue]] may have [[ConfigValueType#NULL]] or
   * any other type, and the passed-in key must be a key in this object (rather
   * than a path expression).
   *
   * @param key
   *   key to look up
   * @return
   *   the value at the key or null if none
   */
  // will not compile with override which is allowed in Java
  override def get(key: Any): ConfigValue

  /**
   * Clone the object with only the given key (and its children) retained; all
   * sibling keys are removed.
   *
   * @param key
   *   key to keep
   * @return
   *   a copy of the object minus all keys except the one specified
   */
  def withOnlyKey(key: String): ConfigObject

  /**
   * Clone the object with the given key removed.
   *
   * @param key
   *   key to remove
   * @return
   *   a copy of the object minus the specified key
   */
  def withoutKey(key: String): ConfigObject

  /**
   * Returns a `ConfigObject` based on this one, but with the given key set to
   * the given value. Does not modify this instance (since it's immutable). If
   * the key already has a value, that value is replaced. To remove a value, use
   * [[ConfigObject#withoutKey]].
   *
   * @param key
   *   key to add
   * @param value
   *   value at the new key
   * @return
   *   the new instance with the new map entry
   */
  def withValue(key: String, value: ConfigValue): ConfigObject

  override def withOrigin(origin: ConfigOrigin): ConfigObject
}
