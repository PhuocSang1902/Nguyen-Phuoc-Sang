import { MedusaRequest, MedusaResponse } from "@medusajs/framework/http"
  import { helloWorkflow } from "../../../workflows/hello-workflow"

  /**
   * POST /store/greet
   * Body: { "name": "John" }
   */
  export async function POST(req: MedusaRequest, res: MedusaResponse) {
    const { name } = req.body as { name?: string }

    if (!name) {
      return res.status(400).json({ error: "Name is required" })
    }

    try {
      // Chạy workflow
      const { result } = await helloWorkflow(req.scope).run({
        input: { name },
      })

      return res.json({
        success: true,
        data: result,
      })
    } catch (error: any) {
      return res.status(400).json({
        success: false,
        error: error.message,
      })
    }
  }