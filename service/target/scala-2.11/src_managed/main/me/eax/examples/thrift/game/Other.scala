/**
 * Generated by Scrooge
 *   version: 3.16.3
 *   rev: b8593c83072d94fc44feaa8d97940b9266d84ed0
 *   built at: 20140806-054445
 */
package me.eax.examples.thrift.game

import com.twitter.scrooge.{
  TFieldBlob, ThriftException, ThriftStruct, ThriftStructCodec3, ThriftStructFieldInfo, ThriftUtil}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object Other extends ThriftStructCodec3[Other] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("other")
  val TagRecMapField = new TField("tagRecMap", TType.MAP, 1)
  val TagRecMapFieldManifest = implicitly[Manifest[Map[Rt, Seq[Rt]]]]
  val RecTagField = new TField("recTag", TType.LIST, 2)
  val RecTagFieldManifest = implicitly[Manifest[Seq[Rt]]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      TagRecMapField,
      false,
      TagRecMapFieldManifest,
      Some(implicitly[Manifest[Rt]]),
      Some(implicitly[Manifest[Seq[Rt]]]),
      immutable$Map(
      ),
      immutable$Map(
      )
    ),
    new ThriftStructFieldInfo(
      RecTagField,
      false,
      RecTagFieldManifest,
      None,
      Some(implicitly[Manifest[Rt]]),
      immutable$Map(
      ),
      immutable$Map(
      )
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map[String, String](
    )

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Other) {
  }

  override def encode(_item: Other, _oproto: TProtocol) {
    _item.write(_oproto)
  }

  override def decode(_iprot: TProtocol): Other = {
    var tagRecMap: Map[Rt, Seq[Rt]] = Map[Rt, Seq[Rt]]()
    var recTag: Seq[Rt] = Seq[Rt]()
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.MAP => {
                tagRecMap = readTagRecMapValue(_iprot)
              }
              case _actualType =>
                val _expectedType = TType.MAP
            
                throw new TProtocolException(
                  "Received wrong type for field 'tagRecMap' (expected=%s, actual=%s).".format(
                    ttypeToHuman(_expectedType),
                    ttypeToHuman(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.LIST => {
                recTag = readRecTagValue(_iprot)
              }
              case _actualType =>
                val _expectedType = TType.LIST
            
                throw new TProtocolException(
                  "Received wrong type for field 'recTag' (expected=%s, actual=%s).".format(
                    ttypeToHuman(_expectedType),
                    ttypeToHuman(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new Immutable(
      tagRecMap,
      recTag,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    tagRecMap: Map[Rt, Seq[Rt]] = Map[Rt, Seq[Rt]](),
    recTag: Seq[Rt] = Seq[Rt]()
  ): Other =
    new Immutable(
      tagRecMap,
      recTag
    )

  def unapply(_item: Other): Option[scala.Product2[Map[Rt, Seq[Rt]], Seq[Rt]]] = Some(_item)


  private def readTagRecMapValue(_iprot: TProtocol): Map[Rt, Seq[Rt]] = {
    val _map = _iprot.readMapBegin()
    if (_map.size == 0) {
      _iprot.readMapEnd()
      Map.empty[Rt, Seq[Rt]]
    } else {
      val _rv = new mutable$HashMap[Rt, Seq[Rt]]
      var _i = 0
      while (_i < _map.size) {
        val _key = {
            Rt.decode(_iprot)
  
        }
        val _value = {
            val _list = _iprot.readListBegin()
            if (_list.size == 0) {
              _iprot.readListEnd()
              Nil
            } else {
              val _rv = new mutable$ArrayBuffer[Rt](_list.size)
              var _i = 0
              while (_i < _list.size) {
                _rv += {
                    Rt.decode(_iprot)
  
                }
                _i += 1
              }
              _iprot.readListEnd()
              _rv
            }
  
        }
        _rv(_key) = _value
        _i += 1
      }
      _iprot.readMapEnd()
      _rv
    }
  }

  private def writeTagRecMapField(tagRecMap_item: Map[Rt, Seq[Rt]], _oprot: TProtocol) {
    _oprot.writeFieldBegin(TagRecMapField)
    writeTagRecMapValue(tagRecMap_item, _oprot)
    _oprot.writeFieldEnd()
  }

  private def writeTagRecMapValue(tagRecMap_item: Map[Rt, Seq[Rt]], _oprot: TProtocol) {
    _oprot.writeMapBegin(new TMap(TType.STRUCT, TType.LIST, tagRecMap_item.size))
    tagRecMap_item.foreach { _pair =>
      val tagRecMap_item_key = _pair._1
      val tagRecMap_item_value = _pair._2
      tagRecMap_item_key.write(_oprot)
      _oprot.writeListBegin(new TList(TType.STRUCT, tagRecMap_item_value.size))
      tagRecMap_item_value.foreach { tagRecMap_item_value_element =>
        tagRecMap_item_value_element.write(_oprot)
      }
      _oprot.writeListEnd()
    }
    _oprot.writeMapEnd()
  }

  private def readRecTagValue(_iprot: TProtocol): Seq[Rt] = {
    val _list = _iprot.readListBegin()
    if (_list.size == 0) {
      _iprot.readListEnd()
      Nil
    } else {
      val _rv = new mutable$ArrayBuffer[Rt](_list.size)
      var _i = 0
      while (_i < _list.size) {
        _rv += {
            Rt.decode(_iprot)
  
        }
        _i += 1
      }
      _iprot.readListEnd()
      _rv
    }
  }

  private def writeRecTagField(recTag_item: Seq[Rt], _oprot: TProtocol) {
    _oprot.writeFieldBegin(RecTagField)
    writeRecTagValue(recTag_item, _oprot)
    _oprot.writeFieldEnd()
  }

  private def writeRecTagValue(recTag_item: Seq[Rt], _oprot: TProtocol) {
    _oprot.writeListBegin(new TList(TType.STRUCT, recTag_item.size))
    recTag_item.foreach { recTag_item_element =>
      recTag_item_element.write(_oprot)
    }
    _oprot.writeListEnd()
  }



  private def ttypeToHuman(byte: Byte) = {
    // from https://github.com/apache/thrift/blob/master/lib/java/src/org/apache/thrift/protocol/TType.java
    byte match {
      case TType.STOP   => "STOP"
      case TType.VOID   => "VOID"
      case TType.BOOL   => "BOOL"
      case TType.BYTE   => "BYTE"
      case TType.DOUBLE => "DOUBLE"
      case TType.I16    => "I16"
      case TType.I32    => "I32"
      case TType.I64    => "I64"
      case TType.STRING => "STRING"
      case TType.STRUCT => "STRUCT"
      case TType.MAP    => "MAP"
      case TType.SET    => "SET"
      case TType.LIST   => "LIST"
      case TType.ENUM   => "ENUM"
      case _            => "UNKNOWN"
    }
  }

  object Immutable extends ThriftStructCodec3[Other] {
    override def encode(_item: Other, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Other = Other.decode(_iprot)
  }

  /**
   * The default read-only implementation of Other.  You typically should not need to
   * directly reference this class; instead, use the Other.apply method to construct
   * new instances.
   */
  class Immutable(
    val tagRecMap: Map[Rt, Seq[Rt]],
    val recTag: Seq[Rt],
    override val _passthroughFields: immutable$Map[Short, TFieldBlob]
  ) extends Other {
    def this(
      tagRecMap: Map[Rt, Seq[Rt]] = Map[Rt, Seq[Rt]](),
      recTag: Seq[Rt] = Seq[Rt]()
    ) = this(
      tagRecMap,
      recTag,
      Map.empty
    )
  }

  /**
   * This Proxy trait allows you to extend the Other trait with additional state or
   * behavior and implement the read-only methods from Other using an underlying
   * instance.
   */
  trait Proxy extends Other {
    protected def _underlying_other: Other
    override def tagRecMap: Map[Rt, Seq[Rt]] = _underlying_other.tagRecMap
    override def recTag: Seq[Rt] = _underlying_other.recTag
    override def _passthroughFields = _underlying_other._passthroughFields
  }
}

trait Other
  extends ThriftStruct
  with scala.Product2[Map[Rt, Seq[Rt]], Seq[Rt]]
  with java.io.Serializable
{
  import Other._

  def tagRecMap: Map[Rt, Seq[Rt]]
  def recTag: Seq[Rt]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = tagRecMap
  def _2 = recTag

  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returend.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) orElse {
      val _fieldOpt: Option[TField] =
        _fieldId match {
          case 1 =>
            if (tagRecMap ne null) {
              writeTagRecMapValue(tagRecMap, _oprot)
              Some(Other.TagRecMapField)
            } else {
              None
            }
          case 2 =>
            if (recTag ne null) {
              writeRecTagValue(recTag, _oprot)
              Some(Other.RecTagField)
            } else {
              None
            }
          case _ => None
        }
      _fieldOpt match {
        case Some(_field) =>
          val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
          Some(TFieldBlob(_field, _data))
        case None =>
          None
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): Other = {
    var tagRecMap: Map[Rt, Seq[Rt]] = this.tagRecMap
    var recTag: Seq[Rt] = this.recTag
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        tagRecMap = readTagRecMapValue(_blob.read)
      case 2 =>
        recTag = readRecTagValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      tagRecMap,
      recTag,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is subtracked
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Other = {
    var tagRecMap: Map[Rt, Seq[Rt]] = this.tagRecMap
    var recTag: Seq[Rt] = this.recTag

    _fieldId match {
      case 1 =>
        tagRecMap = Map[Rt, Seq[Rt]]()
      case 2 =>
        recTag = Seq[Rt]()
      case _ =>
    }
    new Immutable(
      tagRecMap,
      recTag,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is subtracked
   * from the passthroughFields map, if present.
   */
  def unsetTagRecMap: Other = unsetField(1)

  def unsetRecTag: Other = unsetField(2)


  override def write(_oprot: TProtocol) {
    Other.validate(this)
    _oprot.writeStructBegin(Struct)
    if (tagRecMap ne null) writeTagRecMapField(tagRecMap, _oprot)
    if (recTag ne null) writeRecTagField(recTag, _oprot)
    _passthroughFields.values foreach { _.write(_oprot) }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    tagRecMap: Map[Rt, Seq[Rt]] = this.tagRecMap,
    recTag: Seq[Rt] = this.recTag,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Other =
    new Immutable(
      tagRecMap,
      recTag,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Other]

  override def equals(other: Any): Boolean =
    _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
      _passthroughFields == other.asInstanceOf[Other]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => this.tagRecMap
    case 1 => this.recTag
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "Other"
}