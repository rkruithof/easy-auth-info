/**
 * Copyright (C) 2017 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.easy

import java.nio.file.Path

import com.google.common.net.UrlEscapers

import scala.collection.JavaConverters._
import scalaj.http.HttpResponse

package object authinfo {

  type BagInfo = Map[String, String]

  case class HttpStatusException(msg: String, response: HttpResponse[String])
    extends Exception(s"$msg - ${ response.statusLine }, details: ${ response.body }")

  private val pathEscaper = UrlEscapers.urlPathSegmentEscaper()

  def escapePath(path: Path): String = {
    path.asScala.map(_.toString).map(pathEscaper.escape).mkString("/")
  }
}